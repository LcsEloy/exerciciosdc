package exerciciolivro;

import exerciciolivrof.GameHelper;

public class MainSDC {

	public static void main(String[] args) {
		
		int numOfGuesses = 0;
		
		GameHelper helper = new GameHelper();
		
		SimpleDotCom theDotCom = new SimpleDotCom();
		int randomNum = (int) (Math.random() * 5);
		
		int[] locations = {
				randomNum, randomNum+1, randomNum+2
		};
		
		theDotCom.setLocationCells(locations);
		
		boolean isAlive = true;
		
		while (isAlive == true){
			String guess = helper.getUserInput ("Insira um número: ");
			String result = theDotCom.checkYourSelf(guess);
			
			numOfGuesses++;
			if (result.equals("kill")) {
				isAlive = false;
				
				System.out.println("Você usou " + numOfGuesses + " palpites.");
			}
		}
	}
}