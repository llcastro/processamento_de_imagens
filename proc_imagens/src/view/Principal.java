package view;

import controller.Imagem;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.filechooser.*;

public class Principal extends javax.swing.JFrame {

    private BufferedImage imagem_carregada;
    private int flag = 0;
    private String path;

    public Principal() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imagem_tela = new javax.swing.JLabel();
        barra_menu = new javax.swing.JMenuBar();
        menu_arquivo = new javax.swing.JMenu();
        abrir = new javax.swing.JMenuItem();
        reabrir_imagem = new javax.swing.JMenuItem();
        salvar = new javax.swing.JMenuItem();
        sair = new javax.swing.JMenuItem();
        menu_imagem = new javax.swing.JMenu();
        negativo = new javax.swing.JMenuItem();
        escala_de_cinza = new javax.swing.JMenuItem();
        canais = new javax.swing.JMenu();
        canal_vermelho = new javax.swing.JMenuItem();
        canal_verde = new javax.swing.JMenuItem();
        canal_azul = new javax.swing.JMenuItem();
        filtro_sepia = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menu_arquivo.setText("Arquivo");

        abrir.setLabel("Abrir...");
        abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirActionPerformed(evt);
            }
        });
        menu_arquivo.add(abrir);

        reabrir_imagem.setText("Reabrir Imagem");
        reabrir_imagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reabrir_imagemActionPerformed(evt);
            }
        });
        menu_arquivo.add(reabrir_imagem);

        salvar.setLabel("Salvar...");
        salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarActionPerformed(evt);
            }
        });
        menu_arquivo.add(salvar);

        sair.setLabel("Sair");
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });
        menu_arquivo.add(sair);

        barra_menu.add(menu_arquivo);

        menu_imagem.setText("Imagem");

        negativo.setLabel("Negativo");
        negativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                negativoActionPerformed(evt);
            }
        });
        menu_imagem.add(negativo);

        escala_de_cinza.setText("Escala de Cinza");
        escala_de_cinza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escala_de_cinzaActionPerformed(evt);
            }
        });
        menu_imagem.add(escala_de_cinza);

        canais.setText("Canais");

        canal_vermelho.setText("Vermelho");
        canal_vermelho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canal_vermelhoActionPerformed(evt);
            }
        });
        canais.add(canal_vermelho);

        canal_verde.setText("Verde");
        canal_verde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canal_verdeActionPerformed(evt);
            }
        });
        canais.add(canal_verde);

        canal_azul.setText("Azul");
        canal_azul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canal_azulActionPerformed(evt);
            }
        });
        canais.add(canal_azul);

        menu_imagem.add(canais);

        filtro_sepia.setText("Filtro Sépia");
        filtro_sepia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtro_sepiaActionPerformed(evt);
            }
        });
        menu_imagem.add(filtro_sepia);

        barra_menu.add(menu_imagem);

        setJMenuBar(barra_menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(imagem_tela)
                .addGap(0, 400, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(imagem_tela)
                .addGap(0, 279, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirActionPerformed

        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "BMP, JPG, PNG & GIF Images", "jpg", "png", "gif");
        chooser.setCurrentDirectory(new File("/home/luis/Dropbox/pdi/images"));
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Abrir Imagem");
        int op = chooser.showOpenDialog(this);
        if (op == JFileChooser.APPROVE_OPTION) {
            File arq = chooser.getSelectedFile();
            this.path = arq.toString();
            try {
                //carrega nova imagem
                imagem_carregada = ImageIO.read(new File(path));
                System.out.println("Arquivo aberto com sucesso!");
                ImageIcon icon = new ImageIcon(imagem_carregada);
                if (flag == 0) {
                    imagem_tela.setIcon(icon);
                    Container contentPane = getContentPane();
                    contentPane.setLayout(new GridLayout());
                    contentPane.add(new JScrollPane(imagem_tela));
                    flag = 1;
                } else {
                    imagem_tela.setIcon(icon);
                }
                setSize(imagem_carregada.getWidth() + 25, imagem_carregada.getHeight() + 70);
            } catch (IOException e) {
                System.out.println("Erro IO Exception! Verifique se o "
                        + "arquivo especificado existe e tente novamente.");
            } catch (Exception e) {
                System.out.println("Erro Exception! " + e.getMessage());
            }
        }
    }//GEN-LAST:event_abrirActionPerformed

    private void reabrir_imagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reabrir_imagemActionPerformed
        try {
            //recarrega imagem
            imagem_carregada = ImageIO.read(new File(path));
            System.out.println("Arquivo aberto com sucesso!");
            ImageIcon icon = new ImageIcon(imagem_carregada);
            if (flag == 0) {
                imagem_tela.setIcon(icon);
                Container contentPane = getContentPane();
                contentPane.setLayout(new GridLayout());
                contentPane.add(new JScrollPane(imagem_tela));
                flag = 1;
            } else {
                imagem_tela.setIcon(icon);
            }
            setSize(imagem_carregada.getWidth() + 25, imagem_carregada.getHeight() + 70);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro IO Exception! Verifique se o "
                    + "arquivo especificado existe e tente novamente.");
        }
    }//GEN-LAST:event_reabrir_imagemActionPerformed

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        System.exit(1);
    }//GEN-LAST:event_sairActionPerformed

    private void salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarActionPerformed
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG Images", "png");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Salvar Imagem");
        int op = chooser.showSaveDialog(this);
        if (op == JFileChooser.APPROVE_OPTION) {
            File arq = chooser.getSelectedFile();
            String path = arq.toString();
            try {
                ImageIO.write(imagem_carregada, "png", new File(path));
                System.out.println("Arquivo salvo com sucesso!");
            } catch (IOException e) {
                System.out.println("Erro IO Exception! Verifique se o "
                        + "arquivo especificado existe e tente novamente.");
            } catch (Exception e) {
                System.out.println("Erro Exception! " + e.getMessage());
            }
        }
    }//GEN-LAST:event_salvarActionPerformed

    private void negativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_negativoActionPerformed
        new Imagem().negativo(imagem_carregada);
        this.imageUpdate(imagem_carregada, ALLBITS, 0, 0,
                imagem_carregada.getWidth(), imagem_carregada.getHeight());
    }//GEN-LAST:event_negativoActionPerformed

    private void escala_de_cinzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_escala_de_cinzaActionPerformed
        new Imagem().escala_de_cinza(imagem_carregada);
        this.imageUpdate(imagem_carregada, ALLBITS, 0, 0,
                imagem_carregada.getWidth(), imagem_carregada.getHeight());
    }//GEN-LAST:event_escala_de_cinzaActionPerformed

    private void imagem_um_canal() {
        // coloca a imagem com apenas um canal e economiza o tamanho da imagem
        BufferedImage imagem_aux = new BufferedImage(imagem_carregada.getWidth(),
                imagem_carregada.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        Graphics g = imagem_aux.getGraphics();
        g.drawImage(imagem_carregada, 0, 0, null);
        g.dispose();
        imagem_carregada = imagem_aux;
    }

    private void canal_vermelhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canal_vermelhoActionPerformed
        new Imagem().canal_vermelho(imagem_carregada);

        this.imagem_um_canal();
        ImageIcon icon = new ImageIcon(imagem_carregada);
        imagem_tela.setIcon(icon);
        setSize(imagem_carregada.getWidth() + 25, imagem_carregada.getHeight() + 70);
    }//GEN-LAST:event_canal_vermelhoActionPerformed

    private void canal_verdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canal_verdeActionPerformed
        new Imagem().canal_verde(imagem_carregada);

        this.imagem_um_canal();
        ImageIcon icon = new ImageIcon(imagem_carregada);
        imagem_tela.setIcon(icon);
        setSize(imagem_carregada.getWidth() + 25, imagem_carregada.getHeight() + 70);
    }//GEN-LAST:event_canal_verdeActionPerformed

    private void canal_azulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canal_azulActionPerformed
        new Imagem().canal_azul(imagem_carregada);

        this.imagem_um_canal();
        ImageIcon icon = new ImageIcon(imagem_carregada);
        imagem_tela.setIcon(icon);
        setSize(imagem_carregada.getWidth() + 25, imagem_carregada.getHeight() + 70);
    }//GEN-LAST:event_canal_azulActionPerformed

    private void filtro_sepiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtro_sepiaActionPerformed
        new Imagem().filtro_sepia(imagem_carregada);
        this.imageUpdate(imagem_carregada, ALLBITS, 0, 0,
                imagem_carregada.getWidth(), imagem_carregada.getHeight());
    }//GEN-LAST:event_filtro_sepiaActionPerformed

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem abrir;
    private javax.swing.JMenuBar barra_menu;
    private javax.swing.JMenu canais;
    private javax.swing.JMenuItem canal_azul;
    private javax.swing.JMenuItem canal_verde;
    private javax.swing.JMenuItem canal_vermelho;
    private javax.swing.JMenuItem escala_de_cinza;
    private javax.swing.JMenuItem filtro_sepia;
    private javax.swing.JLabel imagem_tela;
    private javax.swing.JMenu menu_arquivo;
    private javax.swing.JMenu menu_imagem;
    private javax.swing.JMenuItem negativo;
    private javax.swing.JMenuItem reabrir_imagem;
    private javax.swing.JMenuItem sair;
    private javax.swing.JMenuItem salvar;
    // End of variables declaration//GEN-END:variables
}
