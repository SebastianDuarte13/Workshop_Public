/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aula9
 */
package form.menu;

import javax.swing.JOptionPane;
import form.menu.Login;


//IMPORTACIONES DE ROLES
import form.roles.application.CreateRolesUseCase;
import form.roles.domain.service.RolesService;
import form.roles.infrastructure.in.RolesController;
import form.roles.infrastructure.out.RolesRepository;

//IMPORTACIONES DE CATEGORIA
import form.category.application.CreateCategoryUseCase;
import form.category.infrastructure.in.CategoryController;
import form.category.infrastructure.out.CategoryRepository;
import form.category.domain.service.CategoryService;

//IMPORTACIONES DE USER ROLL
import form.userrol.application.CreateUserRolUseCase;
import form.userrol.domain.service.UserRolService;
import form.userrol.infrastructure.in.UserRolController;
import form.userrol.infrastructure.out.UserRolRepository;

//IMPORTACIONES DE USUARIOS
import form.user.application.CreateUserUseCase;
import form.user.domain.service.UserService;
import form.user.infrastructure.in.UserController;
import form.user.infrastructure.out.UserRepository;

//IMPORTACIONES SURVEYS
import form.surveys.application.CreateSurveysUseCase;
import form.surveys.infrastructure.out.SurveysRepository;
import form.surveys.infrastructure.out.in.SurveysController;

public class Admin extends javax.swing.JFrame {

    /**
     * Creates new form Admin
     */
    public Admin() {
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

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        roles = new javax.swing.JButton();
        users = new javax.swing.JButton();
        category_catalog = new javax.swing.JButton();
        surveys = new javax.swing.JButton();
        user_roles = new javax.swing.JButton();
        chapter = new javax.swing.JButton();
        questions = new javax.swing.JButton();
        response_options = new javax.swing.JButton();
        subresponse_options = new javax.swing.JButton();
        response_question = new javax.swing.JButton();
        back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setText("ADMIN MENU");

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel1.setText("Select an option");

        roles.setText("Roles");
        roles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rolesActionPerformed(evt);
            }
        });

        users.setText("Users");
        users.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usersActionPerformed(evt);
            }
        });

        category_catalog.setText("Category Catalog");
        category_catalog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                category_catalogActionPerformed(evt);
            }
        });

        surveys.setText("Surveys");
        surveys.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                surveysActionPerformed(evt);
            }
        });

        user_roles.setText("User Roles");
        user_roles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user_rolesActionPerformed(evt);
            }
        });

        chapter.setText("Chapter");
        chapter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chapterActionPerformed(evt);
            }
        });

        questions.setText("Questions");

        response_options.setText("Response Options");

        subresponse_options.setText("Subresponse Options");

        response_question.setText("Response Questions");

        back.setText("Back (Login)");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(surveys, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(category_catalog, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addComponent(users, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(roles, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(chapter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(questions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(response_options, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(subresponse_options, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(user_roles, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(response_question, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                        .addComponent(back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roles)
                    .addComponent(chapter))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(users)
                    .addComponent(questions))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(category_catalog)
                    .addComponent(response_options))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(surveys)
                    .addComponent(subresponse_options))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(user_roles)
                    .addComponent(response_question))
                .addGap(32, 32, 32)
                .addComponent(back)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void category_catalogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_category_catalogActionPerformed
        CategoryRepository categoryRepository = new CategoryRepository();
        CreateCategoryUseCase createCategoryUseCase = new CreateCategoryUseCase(categoryRepository);
        CategoryController categoryController = new CategoryController(createCategoryUseCase, categoryRepository);
        categoryController.tabla_category();
    }//GEN-LAST:event_category_catalogActionPerformed

    private void chapterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chapterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chapterActionPerformed

    private void rolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rolesActionPerformed
        RolesService rolesService = new RolesRepository();
        CreateRolesUseCase createRolesUseCase = new CreateRolesUseCase(rolesService);
        RolesController rolesController = new RolesController(createRolesUseCase, rolesService);
        rolesController.tabla_roles();
    }//GEN-LAST:event_rolesActionPerformed

    private void user_rolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_rolesActionPerformed
        UserRolService userRolService = new UserRolRepository();
        CreateUserRolUseCase createUserRolUseCase = new CreateUserRolUseCase(userRolService);
        UserRolController userRolController = new UserRolController(createUserRolUseCase, null);
        userRolController.tabla_userrol();
    }//GEN-LAST:event_user_rolesActionPerformed

    private void usersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usersActionPerformed
        UserService userService = new UserRepository();
        CreateUserUseCase createUserUseCase = new CreateUserUseCase(userService);
        UserController userController = new UserController(createUserUseCase, userService);
        userController.tabla_user();  
    }//GEN-LAST:event_usersActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // Cerrar la ventana actual
        this.dispose();

        // Muestra Login
        Login login = new Login();
        login.setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void surveysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_surveysActionPerformed
        SurveysRepository surveysRepository = new SurveysRepository();
        CreateSurveysUseCase createSurveysUseCase = new CreateSurveysUseCase(surveysRepository);
        SurveysController SurveysController = new SurveysController(createSurveysUseCase, surveysRepository);
        SurveysController.tabla_Surveys();
    }//GEN-LAST:event_surveysActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
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
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton category_catalog;
    private javax.swing.JButton chapter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton questions;
    private javax.swing.JButton response_options;
    private javax.swing.JButton response_question;
    private javax.swing.JButton roles;
    private javax.swing.JButton subresponse_options;
    private javax.swing.JButton surveys;
    private javax.swing.JButton user_roles;
    private javax.swing.JButton users;
    // End of variables declaration//GEN-END:variables
}
