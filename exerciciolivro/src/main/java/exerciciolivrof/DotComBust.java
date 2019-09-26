package exerciciolivrof;

import java.util.ArrayList;

public class DotComBust {
	
	private GameHelper helper = new GameHelper();
	private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
	private int numOfGuesses = 0;
	
	private void setUpGame() {
		DotCom one = new DotCom();
		one.setName("globo.com");
		
		DotCom two = new DotCom();
		two.setName("google.com");
		
		DotCom three = new DotCom();
		three.setName("facebook.com");
		
		dotComsList.add(one);
		dotComsList.add(two);
		dotComsList.add(three);
		
		System.out.println("Seu Objetivo é eliminar três dot coms.");
		System.out.println("globo.com, google.com e facebook.com");
		System.out.println("Tente eliminar todas com o menor número de palpites");
		
		for (DotCom dotComToSet : dotComsList) {
			ArrayList<String> newLocation = helper.placeDotCom(3);
			dotComToSet.setLocationCells(newLocation);
		}
	}
	
	private void startPlaying() {
		while (!dotComsList.isEmpty()){
			String userGuess = helper.getUserInput("Insira um palpite");
			checkUserGuess(userGuess);
		}
		finishGame();
	}
	
	private void checkUserGuess(String userGuess) {
		numOfGuesses++;
		String result = "errado";
		for (DotCom dotComToTest : dotComsList) {
			result = dotComToTest.checkYourself(userGuess);
			if (result.equals("correto")) {
				break;
			}
			if (result.equals("eliminar")) {
				dotComsList.remove(dotComToTest);
				break;
			}
		}
		System.out.println(result);
	}
	
	private void finishGame() {
		System.out.println("Todas as Dot Coms foram eliminadas! Agora seu conjunto está vazio.");
		if (numOfGuesses <= 18) {
			System.out.println("Você só usou: " + numOfGuesses + " palpites.");
			System.out.println("Você saiu antes de eliminar todas suas opções.");
		} else {
			System.out.println("Demorou demais. " + numOfGuesses + " palpites.");
			System.out.println("Não haverá pesca com essas opções.");
		}
	}
	
	public static void main (String[] agrs) {
		DotComBust game = new DotComBust();
		game.setUpGame();
		game.startPlaying();
	}

}
