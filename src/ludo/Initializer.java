package ludo;

import ludo.view.LudoPanel;

/**
 * A class used to launch the Ludo game.
 * 
 * @author Katie Mulder
 */
public final class Initializer {
  /**
   * A private constructor to prevent initialization.
   */
  private Initializer() {
  }

  /**
   * The entry point of the code to create a LudoPanel.
   * 
   * @param args
   *          The program command-line parameters
   */
  public static void main(final String[] args) {
    new LudoPanel();
  }
}
