/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import civitas.CivitasJuego;
import civitas.OperacionInmobiliaria;
import civitas.OperacionJuego;
import controladorCivitas.Respuesta;
import javax.swing.JOptionPane;

/**
 *
 * @author valentino
 */
public class CivitasView extends javax.swing.JFrame implements Vista
{

    
    CivitasJuego juego;
    
    /**
     * Creates new form CivitasView
     */
    public CivitasView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jugadorPanel1 = new GUI.JugadorPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jugadorPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(107, 107, 107)
                .addComponent(jugadorPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 139, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void actualiza() 
    {
        this.jugadorPanel1.setJugador(juego.getJugadorActual());
    }

    @Override
    public void pausa() 
    {
        int val = JOptionPane.showConfirmDialog(null, "¿Continuar?", "Siguiente Paso", JOptionPane.YES_NO_OPTION);
        
        if(val == 1)
        {
            System.exit(0);
        }
    }

    @Override
    public Respuesta comprar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OperacionInmobiliaria elegirOperacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int elegirPropiedad() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mostrarSiguienteOperacion(OperacionJuego operación) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mostrarEventos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Vincula la vista con el modelo
     * @param vidya 
     */
    void setCitivasJuego(CivitasJuego vidya)
    {
        this.juego = vidya;
        setVisible(true);
    }
   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private GUI.JugadorPanel jugadorPanel1;
    // End of variables declaration//GEN-END:variables
}
