package com.studentmanagament.model;

public class Marks {

	private float javaMarks;
	private float sqlMarks;
	private float springMarks;
	private float htmlMarks;
	private float reactMarks;

	public void setJavaMarks(float javaMarks) {
		this.javaMarks = javaMarks;
	}

	public void setSqlMarks(float sqlMarks) {
		this.sqlMarks = sqlMarks;
	}

	public void setSpringMarks(float springMarks) {
		this.springMarks = springMarks;
	}

	public void setHtmlMarks(float htmlMarks) {
		this.htmlMarks = htmlMarks;
	}

	public void setReactMarks(float reactMarks) {
		this.reactMarks = reactMarks;
	}

	public float getJavaMarks() {
		return javaMarks;
	}

	public float getSqlMarks() {
		return sqlMarks;
	}

	public float getSpringMarks() {
		return springMarks;
	}

	public float getHtmlMarks() {
		return htmlMarks;
	}

	public float getReactMarks() {
		return reactMarks;
	}

	public float calculateTotal() {

		float total = javaMarks + sqlMarks + springMarks + htmlMarks + reactMarks;

		return total;
	}

	public float calculatePercentage() {

		float total = calculateTotal();

		float percentage = (total / 500) * 100;

		return percentage;
	}

	public boolean isPassed() {

		if (javaMarks >= 40 && sqlMarks >= 40 && springMarks >= 40 && htmlMarks >= 40 && reactMarks >= 40) {

			return true;

		} else {

			return false;
		}
	}

	public String calculateGrade() {

		if (!isPassed()) {
			return "F";
		}

		float percentage = calculatePercentage();

		if (percentage >= 91) {
			return "A+";
		} else if (percentage >= 81) {
			return "A";
		} else if (percentage >= 71) {
			return "B+";
		} else if (percentage >= 61) {
			return "B";
		} else if (percentage >= 51) {
			return "C+";
		} else if (percentage >= 41) {
			return "C";
		} else {
			return "F";
		}
	}

	@Override
	public String toString() {
		return "\nMark Of this Student \n" + "javaMarks = " + javaMarks + ", \nsqlMarks = " + sqlMarks
				+ ", \nspringMarks = " + springMarks + ", \nhtmlMarks = " + htmlMarks + ", \nreactMarks = " + reactMarks
				+ "\n";
	}
}
