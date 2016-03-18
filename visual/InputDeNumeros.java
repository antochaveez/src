package visual;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputDeNumeros extends KeyAdapter{
    
            @Override
            public void keyTyped(KeyEvent e) {
               char c = e.getKeyChar();
               
               if (c < '0' || c > '9'){
                   e.consume();
               }
            }
}
