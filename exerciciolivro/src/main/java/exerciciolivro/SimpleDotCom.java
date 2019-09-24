package exerciciolivro;

public class SimpleDotCom {

	int[] locationCells;
	int numOfHits = 0;
	
	public void setLocationCells (int[] locs) {
		locationCells = locs;
	}

	public String checkYourSelf(String stringGuess) {
		int guess = Integer.parseInt(stringGuess);
		
		String result = "miss";
		for (int cell : locationCells) {
			if (guess == cell) {
				result = "hit";
				numOfHits++;
				break;
			} // fim if
		} // fim for

		if (numOfHits == locationCells.length) {
			result = "kill";
		} // fim if
		System.out.println(result);
		return result;
  }
}
