package org.sakaiproject.gradebook.gwt.sakai.calculations2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import org.sakaiproject.gradebook.gwt.sakai.calculations2.GradeRecordCalculationUnit;
import org.sakaiproject.gradebook.gwt.sakai.calculations2.CategoryCalculationUnit;

public class CategoryCalculationUnitImpl extends BigDecimalCalculationsWrapper implements CategoryCalculationUnit {

	private BigDecimal categoryGrade;

	// This is the desired weight for the category that the user enters
	private BigDecimal categoryWeightTotal;

	private int dropLowest;
	private boolean isExtraCredit;
	private boolean isPointsWeighted;
	private BigDecimal totalCategoryPoints;

	private List<GradeRecordCalculationUnit> unitsToDrop;

	// Making default constructor private since this class needs to be instantiated with a scale
	private CategoryCalculationUnitImpl() {
	}
	
	public CategoryCalculationUnitImpl(BigDecimal categoryWeightTotal, Integer dropLowest, Boolean extraCredit, Boolean usePoints, int scale) {
		super(scale);
		this.categoryWeightTotal = categoryWeightTotal;
		this.dropLowest = dropLowest == null ? 0 : dropLowest.intValue();
		this.isExtraCredit = extraCredit == null ? false : extraCredit.booleanValue();
		this.unitsToDrop = new LinkedList<GradeRecordCalculationUnit>();
		this.isPointsWeighted = usePoints == null ? false : usePoints.booleanValue();
	}


	public BigDecimal calculate(List<GradeRecordCalculationUnit> units, boolean isExtraCreditScaled) {	

		if (units == null)
			return null;
		
		BigDecimal sumScores = sumScaledScores(units, isExtraCreditScaled);

		// When drop lowest is not set, the calculation is very straightforward
		if (dropLowest <= 0) {
			categoryGrade = sumScores;
			return categoryGrade;
		}

		// Note that drop lowest only works when all the scores for this category are equally weighted
		Collections.sort(units, new Comparator<GradeRecordCalculationUnit>() {

			public int compare(GradeRecordCalculationUnit o1, GradeRecordCalculationUnit o2) {
				if (o2 == null || o1 == null)
					return 0;

				if (o1.getScaledScore() == null || o2.getScaledScore() == null)
					return 0;

				return o1.getScaledScore().compareTo(o2.getScaledScore());
			}

		});

		int numberOfUnitsDropped = 0;

		List<GradeRecordCalculationUnit> unitsToCount = new ArrayList<GradeRecordCalculationUnit>();

		// We don't want to include excused records in our determination of drop lowest items
		for (GradeRecordCalculationUnit unit : units) {
			if (numberOfUnitsDropped < dropLowest && !unit.isExcused() && !unit.isExtraCredit()) {
				unit.setDropped(true);
				unitsToDrop.add(unit);
				numberOfUnitsDropped++;
			} else {
				unit.setDropped(false);
				unitsToCount.add(unit);
			}
		}

		categoryGrade = sumScaledScores(unitsToCount, isExtraCreditScaled);
		return categoryGrade;
	}


	private BigDecimal sumScaledScores(List<GradeRecordCalculationUnit> units, boolean isExtraCreditScaled) {
		BigDecimal sum = sumUnitWeights(units, false);

		if (sum == null)
			return null;

		BigDecimal ratio = BigDecimal.ONE;

		if (sum.compareTo(BigDecimal.ZERO) != 0) 
			ratio = divide(BigDecimal.ONE, sum);
			//ratio = BigDecimal.ONE.setScale(AppConstants.SCALE).divide(sum, RoundingMode.HALF_EVEN);

		BigDecimal sumScores = null;

		for (GradeRecordCalculationUnit unit : units) {

			if (unit.isExcused())
				continue;

			BigDecimal multiplicand = ratio;

			if (unit.isExtraCredit()) {
				if (isExtraCreditScaled && isExtraCredit) 
					multiplicand = ratio; // GRBK-476 : was BigDecimal.valueOf(100d).multiply(categoryWeightTotal);
				else
					multiplicand = BigDecimal.ONE;
			}
			
			BigDecimal scaledItemWeight = findScaledItemWeight(multiplicand, unit.getPercentOfCategory());
			BigDecimal scaledScore = unit.calculate(scaledItemWeight);

			if (scaledScore != null) {
				if (sumScores == null)
					sumScores = BigDecimal.ZERO;

				sumScores = add(sumScores, scaledScore);
				//sumScores = sumScores.add(scaledScore);
			}
		}

		return sumScores;
	}


	private BigDecimal findScaledItemWeight(BigDecimal ratio, BigDecimal itemWeight) {
		if (ratio == null || itemWeight == null)
			return null;
		
		return multiply(ratio, itemWeight);
		//return ratio.multiply(itemWeight);
	}

	private BigDecimal sumUnitWeights(List<GradeRecordCalculationUnit> units, boolean doExtraCredit) {

		BigDecimal sumUnitWeight = null;

		if (units != null) {
			for (GradeRecordCalculationUnit unit : units) {

				if (unit.isExtraCredit() && !isExtraCredit)
					continue;

				if (unit.isExcused())
					continue;

				BigDecimal itemWeight = unit.getPercentOfCategory();

				if (itemWeight != null) {
					if (sumUnitWeight == null) 
						sumUnitWeight = BigDecimal.ZERO;

					sumUnitWeight = add(sumUnitWeight, itemWeight);
					//sumUnitWeight = sumUnitWeight.add(itemWeight);
				}
			}
		}

		return sumUnitWeight;
	}

	public boolean isExtraCredit() {
		return isExtraCredit;
	}


	public BigDecimal getCategoryWeightTotal() {
		return categoryWeightTotal;
	}


	public BigDecimal getCategoryGrade() {
		return categoryGrade;
	}


	public int getDropLowest() {
		return dropLowest;
	}


	public void setDropLowest(int dropLowest) {
		this.dropLowest = dropLowest;
	}


	public boolean isPointsWeighted() {
		return isPointsWeighted;
	}


	public void setPointsWeighted(boolean isPointsWeighted) {
		this.isPointsWeighted = isPointsWeighted;
	}


	public void setCategoryGrade(BigDecimal categoryGrade) {
		this.categoryGrade = categoryGrade;
	}


	public BigDecimal getTotalCategoryPoints() {
		return totalCategoryPoints;
	}


	public void setTotalCategoryPoints(BigDecimal totalCategoryPoints) {
		this.totalCategoryPoints = totalCategoryPoints;
	}
}
