package aplikacja.gameBoard.ui;

import java.awt.*;

public class PaintDialogComponent {

    private String CURRENT_DIALOG;


    public void paintDialog(Graphics graphics){
        //to bedzie glowna funkcja do rysowania komponentu
    }

    //changeStatemenent

    public void changeDialog(){
        if(CURRENT_DIALOG.equals("COS TAM")){
            CURRENT_DIALOG = "APE";
        }
    }
}
