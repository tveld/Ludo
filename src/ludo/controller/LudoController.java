package ludo.controller;

import ludo.model.LudoModel;
import ludo.view.LudoView;

public class LudoController {
	LudoModel lModel;
	LudoView lView;

	public static void main(String[] args) {
		LudoModel lmodel = new LudoModel();
		LudoView lview = new LudoView();
		lview.printBoard(lmodel);
	}
}
