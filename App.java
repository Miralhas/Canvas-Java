import java.awt.*;
import javax.swing.*;


public class App {
    public static void main(String[] args) {
        JFrame window = new JFrame("Art");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Termina o processo ao fechar a janela. 
        // window.setSize(900, 600);

        
        // Cria uma tela (canvas) para desenhar
        MyCanvas canvas = new MyCanvas();
        // Adiciona o canvas à janela
        window.add(canvas);

        // Ajusta o tamanho da window em torno dos componentes 
        window.pack();
        // Mostra a janela
        window.setVisible(true);
        // Abre a janela no centro da tela.
        window.setLocationRelativeTo(null);
        // Não deixa o usuário ajustar a tela.
        window.setResizable(false);
    }
}

// Criei uma classe filho chamada MyCanvas, nela será feita a pintura do canvas.
class MyCanvas extends JPanel {

    //Construtor - Ao criar um objeto da Classe MyCanvas, executa tudo que está no construtor.
    public MyCanvas(){
        setPreferredSize(new Dimension(900, 600));

        setBackground(Color.white);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        Paintbrush myBrush = new Paintbrush(g);

        myBrush.drawGrass();
        myBrush.drawSky();
        myBrush.drawMountains();
        myBrush.drawFlower();
        myBrush.drawTree();
        myBrush.drawCloud();

    }
}

class Paintbrush {
    private Graphics g;

    public Paintbrush(Graphics graphics){
        g = graphics;
    }

    public void drawSky(){
        // faz um céu azul
        g.setColor(new Color(17, 17, 48));
        g.fillRect(0,0, 900, 270);

        // faz um sol (fillOval) amarelo
        g.setColor(Color.yellow);
        g.fillOval(700, 30, 60, 60);

    }

    public void drawMountains(){
        g.setColor(new Color(54, 43, 37));
        Polygon triangle = new Polygon();
        triangle.addPoint(0, 600); // bottom-left
        triangle.addPoint(150, 300); // top
        triangle.addPoint(280, 600); // bottom-right
        g.fillPolygon(triangle);

        g.setColor(new Color(227, 113, 36));
        Polygon lava = new Polygon();
        lava.addPoint(110, 375);
        lava.addPoint(150, 300);
        lava.addPoint(183, 375);
        g.fillPolygon(lava);
        
    }

    public void drawTree(){
        g.setColor(new Color(64, 43, 33));
        g.fillRect(680, 450, 30, 150);

        
        g.setColor(Color.green);
        g.fillRect(640, 350, 108, 110);
        
        int yMaca = 360;

        for (int i = 0; i < 3; i++){
            int xMaca = 650;
            for (int k = 0; k < 3; k++){
                g.setColor(Color.red);
                g.fillRect(xMaca, yMaca, 20, 20);
                xMaca += 35;
            }
            yMaca += 35;
        }
    }

    public void drawCloud(){
        int xNuvem = 0;
        int yNuvem = 0;
        g.setColor(new Color(204,204,204));

        for (int i = 0; i < 3; i++){
            g.fillOval(50, yNuvem, 100, 60);
            yNuvem += 30;
        }
        for (int j = 0; j < 2; j++){
            g.fillOval(xNuvem, 30, 100, 60);
            xNuvem += 100;
        }

    }

    public void drawGrass(){
        Color gramaPerto = new Color (37, 74, 35);
        Color gramaLonge = new Color (26, 48, 25);
        GradientPaint grassMix = new GradientPaint(0, 0, gramaPerto, 0, 500, gramaLonge);

        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(grassMix);
        g2.fillRect(0, 220, 900, 600);
    }

    public void drawFlower(){
        g.setColor(new Color(0, 0, 0));
        g.fillRect(400, 555, 10, 120);

        g.setColor(Color.red);
        g.fillOval(374, 495, 60, 60);

        g.setColor(Color.yellow);
        g.fillOval(389, 510, 30, 30);

    }
}