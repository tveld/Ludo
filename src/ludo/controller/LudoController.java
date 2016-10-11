package ludo.controller;

import ludo.model.LudoModel;
import ludo.view.LudoView;

public class LudoController {

  /**
   * This class is the controller portion of the MVC.
   * 
   * @param args command-line arguments
   */
  public static void main(String[] args) {
    LudoModel ludoModel = new LudoModel();
    LudoView ludoView = new LudoView();
    ludoView.printBoard(ludoModel);
  }
}
