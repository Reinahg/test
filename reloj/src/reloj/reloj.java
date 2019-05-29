package reloj;

import java.util.*;

public class reloj extends javax.swing.JFrame implements Runnable{

    String hora, minutos, segundos, ampm;
    Calendar calendario;
    Thread h1; //hilo
    
    
    
    public reloj() {
        initComponents();
        h1 = new Thread(this);
        h1.start();
        setLocationRelativeTo(null);
        setTitle("Reloj");
        setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblReloj = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();             //Comentario para la prueba numero 2

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblReloj.setBackground(new java.awt.Color(0, 0, 0));
        lblReloj.setFont(new java.awt.Font("Malgun Gothic Semilight", 3, 36)); // NOI18N
        lblReloj.setForeground(new java.awt.Color(73, 165, 80));
        lblReloj.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReloj.setText("lblReloj");
        lblReloj.setMaximumSize(new java.awt.Dimension(46, 25));
        lblReloj.setMinimumSize(new java.awt.Dimension(46, 25));
        lblReloj.setOpaque(true);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setForeground(new java.awt.Color(73, 165, 80));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(" ");
        jLabel1.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblReloj, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblReloj, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblReloj;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
       Thread ct= Thread.currentThread(); //define el hilo
       while(ct==h1){
           calcula();
           lblReloj.setText(hora+":"+minutos+":"+segundos+" "+ampm); //ponemos el texto en el cuadro
           try{
               Thread.sleep(1000);//que se actualice cada segundo
               int horanum = Integer.parseInt(hora);   //ponemos la hora en enteros para poder hacer la alarma
               int minunum = Integer.parseInt(minutos);
               int segnum = Integer.parseInt(segundos);
               if(
                       horanum == 20 && minunum == 28 && segnum == 50 && ampm == "PM" || //pones las alarmas que quieras
                       horanum == 20 && minunum == 43 && segnum == 00 && ampm == "AM"
                       
               ){
                   jLabel1.setText("Despierta");
               }else{
                   jLabel1.setText("Sigue durmiendo");
               }
           }catch(InterruptedException e){}
           
       }
    
    }

    private void calcula() {
       Calendar calendario = new GregorianCalendar();
       Date fechaHoraActual = new Date();
       
       calendario.setTime(fechaHoraActual);
       ampm = calendario.get(Calendar.AM_PM)==Calendar.AM?"AM":"PM";
       
       //if(ampm.equals("PM")){
       //    int h= calendario.get(Calendar.HOUR_OF_DAY)-12; //si es de la tarde le quita 12 horas 
       //    hora = h>9?""+h:"0"+h; //si solo es un numero le pone un cero antes para 08:00
       //}else{
           hora= calendario.get(Calendar.HOUR_OF_DAY)>9?""+calendario.get(Calendar.HOUR_OF_DAY):"0"+calendario.get(Calendar.HOUR_OF_DAY);
       //
       //}
       minutos = calendario.get(Calendar.MINUTE)>9?""+calendario.get(Calendar.MINUTE):"0"+calendario.get(Calendar.MINUTE);
       segundos = calendario.get(Calendar.SECOND)>9?""+calendario.get(Calendar.SECOND):"0"+calendario.get(Calendar.SECOND);
    }
}
