import java.awt.*;
 import java.awt.event.*;
  import javax.swing.*;

public class cajero extends JFrame

{
		private final JButton acc; 
		private final JTextField contra;
	    private final String nip="admin";
		private double saldoTotal = 10000.0; 
		private JTextField campo1;
		private JTextField campo2;
		
		public cajero()
		{
		
				JFrame ven  = new JFrame("CAJERO ERNESTO "); 
				ven.setLayout(null);
				ven.setBounds(500,150,500,300); 
				ven.setVisible(true);
				JLabel nombre= new JLabel(); 
				ven.add(nombre);
				 nombre.setBounds(100,53,250,50);
				nombre.setFont(new Font("",Font.BOLD,20));
			    nombre.setForeground(Color.RED );
			     nombre.setText("INGRESE SU NIP:");
				setLocationRelativeTo(null);
				acc = new JButton( "ACCESAR" );
				ven.add( acc ); 
				acc.setBounds(150,160,150,40);
				contra = new JTextField( 15 ); 
				ven.add( contra); 
				contra.setBounds(100,100,300,50);
				ManejadorBoton manejador = new ManejadorBoton();
			    acc.addActionListener( manejador );
			     dispose();
		
				}
				public void nom(){
				String nom2=contra.getText();
				}
				public static void main( String args[] )	{ 
					cajero aplicacion = new cajero();	}
				private class ManejadorBoton implements ActionListener
				{
				private JButton depo;
			    private JButton reti; 
				private JButton cons;
				
				@Override
				public void actionPerformed( ActionEvent evento )
				{
				if(nip.equals(contra.getText()))
				{
				JFrame VEN1 = new JFrame("CAJERO.02_ERNESTO"); 
				VEN1.setLayout(null); 
				VEN1.setBounds(500,150,350,300);
				VEN1.setVisible(true);
				depo = new JButton( "DEPOSITAR" );
			    VEN1.add( depo ); 
			    depo.setBounds(120,20,120,40);
				reti = new JButton( "RETIRAR" );
			    VEN1.add( reti );
			    reti.setBounds(120,70,120,40);
				cons = new JButton( "CONSULTAR" ); 
				VEN1.add( cons );
			    cons.setBounds(120,120,120,40);
				Manejadordepo manejador = new Manejadordepo();
				depo.addActionListener( manejador );
				Manejadorreti manejador2 = new Manejadorreti();
				reti.addActionListener( manejador2 );
				Manejadorcons manejador3 = new Manejadorcons();
				cons.addActionListener( manejador3 );
				}
				else
				{
				JOptionPane.showMessageDialog(null,"LA CLAVE INTRODUCIDA ES INCORRECTA");
				}
				}
				}
				private class Manejadordepo implements ActionListener
				{
				private JButton depositar;
				@Override
				public void actionPerformed( ActionEvent evento )
				{
					JFrame ven3 = new JFrame("DEPOSITO");
					ven3.setLayout(null); 
					ven3.setBounds(500,150,400,400); 
				    ven3.setVisible(true);
					JLabel a= new JLabel(); 
					ven3.add(a); 
					a.setBounds(100,0,200,200);
					a.setFont(new Font("Arial",Font.BOLD,20));
					 a.setForeground(Color.red); 
					 	a.setText("ingresa la cantidad:");
					campo1 = new JTextField( 15 ); 
						ven3.add( campo1);
						 campo1.setBounds(80,150,200,50);
					depositar = new JButton( "depositar" ); 
						ven3.add( depositar );
						 depositar.setBounds(110,210,150,40);
					Manejadordepodos manejador4 = new Manejadordepodos(); 
						depositar.addActionListener( manejador4 );
					
					}
					}
					private class Manejadordepodos implements ActionListener
					{
					@Override
					public void actionPerformed( ActionEvent evento )
					{
					saldoTotal = saldoTotal + Double.parseDouble( campo1.getText() );
					 JOptionPane.showMessageDialog(null, "Deposito exitoso!");
					}
					}
					private class Manejadorreti implements ActionListener
					{
					private JButton retiro;
					@Override
					public void actionPerformed( ActionEvent evento )
					{
					JFrame ven4 = new JFrame("RETIRO");
					 ven4.setLayout(null); 
					 	ven4.setBounds(500,150,400,400);
					 	 ven4.setVisible(true);
					JLabel b= new JLabel(); ven4.add(b);
					 b.setBounds(100,0,200,200);
					b.setFont(new Font("Arial",Font.BOLD,20));
					 b.setForeground(Color.red); b.setText("cantidad a retirar :");
					campo2 = new JTextField( 15 );
					 ven4.add( campo2); campo2.setBounds(80,180,200,50);
					retiro = new JButton( "retirar" );
					 ven4.add( retiro );
					  retiro.setBounds(100,250,150,75);
					  
					Manejadorretidos manejador5 = new Manejadorretidos(); 
						retiro.addActionListener( manejador5 );
					}
				}
				private class Manejadorretidos implements ActionListener
				{
				@Override
				public void actionPerformed( ActionEvent evento )
				{
				double cantidad_que_retira = Double.parseDouble( campo2.getText() );
				 if( saldoTotal < cantidad_que_retira ){ 
				 	JOptionPane.showMessageDialog(null, "Saldo Insuficiente!");
				} 
					else {
				if( cantidad_que_retira > 5500 ){
				JOptionPane.showMessageDialog(null, "Solo puede hacer retiros menores o iguales a 5500!");
				}
				else{
				if( cantidad_que_retira%100 == 0 ){ saldoTotal = saldoTotal - cantidad_que_retira;
				int mil=0, 
				quinientos=0, 
				docientos=0,
				cien=0; 
				while(cantidad_que_retira>1000){
				mil++;
				cantidad_que_retira-=1000; }
				while(cantidad_que_retira>500){ quinientos++;
				cantidad_que_retira-=500;} while(cantidad_que_retira>200){
				docientos++; cantidad_que_retira-=200;} while(cantidad_que_retira>=100){
				cien++; cantidad_que_retira-=100;}
				String billetes = "\n$1000 --- " + mil + "\n$500 --- " + quinientos + "\n$200 --- " + docientos
				+ "\n$100 --- " + cien;
				
				JOptionPane.showMessageDialog(null, "Retiro bien hecho!" + billetes);
				} else {
				JOptionPane.showMessageDialog(null, "Solo puedes retirar multiplos de 100");
				}
				
				}
				}
				}
		
				}
				private class Manejadorcons implements ActionListener
				{
				private JTextField campo3;
				@Override
				public void actionPerformed( ActionEvent evento )
				{
				JFrame ven5 = new JFrame("CONSULTA");
				 ven5.setLayout(null); 
				 	ven5.setBounds(500,150,350,150);
				 	 ven5.setVisible(true);
				JLabel c= new JLabel(); ven5.add(c);
				 c.setBounds(10,30,350,20);
				c.setFont(new Font("Arial",Font.BOLD,20));
				 c.setForeground(Color.red); 
				 	c.setText("TU SALDO ES:   " + saldoTotal);
		}
}
}
