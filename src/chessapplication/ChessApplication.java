package chessapplication;

/**
 * @author Juriel Garcia, Kevin Tang, Violet Leong
 * @version 1.0.0
 */

public class ChessApplication {

    public static void main(String[] args) {
    //<editor-fold defaultstate="collapsed" desc="Look and feel setting code (optional) ">
        /* Set the Nimbus look and feel */
  
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="GUI Thread">
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                w = new Window();
//                
//            }
//        });
        //</editor-fold>
        
        Game g = new Game();
        g.Init();
        //g.startMenu();
        while(g.getIsRunning()){
            g.Run();
        }
    }
}
