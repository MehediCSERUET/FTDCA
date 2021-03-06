/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ftdca;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Post;
import facebook4j.Reading;
import facebook4j.conf.Configuration;
import facebook4j.conf.ConfigurationBuilder;
import java.io.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import javax.swing.table.*;
/**
 *
 * @author Mehedi Hasan
 */
public class FacebookResult extends javax.swing.JFrame {
    private String AccessToken, GroupId;
    private JSONObject obj;
    private JSONArray list;
    private boolean IsTableLoaded =  false;
    private DefaultTableModel row;
    
    /**
     * Creates new form FacebookResult
     */
    public FacebookResult() {
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

        AccessTokenLabel = new javax.swing.JLabel();
        GroupIdLabel = new javax.swing.JLabel();
        GroupIdField = new javax.swing.JTextField();
        SearchButton = new javax.swing.JButton();
        AccessTokenField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        ResultTable = new javax.swing.JTable();
        BacktoMenuButton = new javax.swing.JButton();
        SaveButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        NoOfPosts = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(3840, 2160));
        setMinimumSize(new java.awt.Dimension(1200, 700));

        AccessTokenLabel.setFont(new java.awt.Font("Lucida Calligraphy", 0, 14)); // NOI18N
        AccessTokenLabel.setText("Enter AccessToken");

        GroupIdLabel.setFont(new java.awt.Font("Lucida Calligraphy", 0, 14)); // NOI18N
        GroupIdLabel.setText("Enter Group ID");

        SearchButton.setFont(new java.awt.Font("Lucida Calligraphy", 0, 14)); // NOI18N
        SearchButton.setText("Search");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        ResultTable.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        ResultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Post", "Date", "PostId"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ResultTable.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(ResultTable);
        ResultTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (ResultTable.getColumnModel().getColumnCount() > 0) {
            ResultTable.getColumnModel().getColumn(0).setPreferredWidth(35);
            ResultTable.getColumnModel().getColumn(1).setPreferredWidth(1040);
            ResultTable.getColumnModel().getColumn(2).setPreferredWidth(75);
            ResultTable.getColumnModel().getColumn(3).setPreferredWidth(50);
        }

        BacktoMenuButton.setFont(new java.awt.Font("Lucida Calligraphy", 0, 14)); // NOI18N
        BacktoMenuButton.setText("Menu");
        BacktoMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BacktoMenuButtonActionPerformed(evt);
            }
        });

        SaveButton.setFont(new java.awt.Font("Lucida Calligraphy", 0, 14)); // NOI18N
        SaveButton.setText("Save");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jLabel1.setText("Number");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 2, Short.MAX_VALUE)
                .addComponent(BacktoMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AccessTokenLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GroupIdLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AccessTokenField, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(GroupIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1)
                        .addGap(19, 19, 19)
                        .addComponent(NoOfPosts)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(BacktoMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AccessTokenLabel)
                            .addComponent(AccessTokenField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NoOfPosts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(GroupIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1)
                                .addComponent(GroupIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
     if(AccessTokenField.getText().isEmpty() || GroupIdField.getText().isEmpty()){ //checking if the accesstoken and the group/page id is given or not, and if empty then
         JOptionPane.showMessageDialog(null, "Both Fields are required!"); //showing this text
     } else { //if not empty
        AccessToken = AccessTokenField.getText();  //getting user access token
        GroupId = GroupIdField.getText();  //getting group/page id, for example RealMadrid
        obj = new JSONObject(); //creating a JSONObject where we will save json
        list = new JSONArray(); //creating a JSONArray, it will be inserted in jsonobject
        try {
            ConfigurationStarter(); //this configurationStarter configures Facebook4j library's configuration to fetch data
        } catch (FacebookException ex) {
            Logger.getLogger(FacebookResult.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    }//GEN-LAST:event_SearchButtonActionPerformed

    private void BacktoMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BacktoMenuButtonActionPerformed
        this.setVisible(false);
        Menu menu = new Menu();
        menu.setVisible(true);
    }//GEN-LAST:event_BacktoMenuButtonActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        if(IsTableLoaded){ //if the table has data on it 
            obj = new JSONObject(); 
            list = new JSONArray();
            int r = row.getRowCount(); //return the number of rows
            for(int m = 0; m < r; m++){
                if(row.getValueAt(m, 1)!= null){ //if the post field is not null
                    list.add(row.getValueAt(m, 1)); //always ignore 1st column, it is id and not necessary
                    list.add(row.getValueAt(m, 2));
                    list.add(row.getValueAt(m, 3));
                }
            }
            
            try {
                obj.put("data", list); //key->data value->list
                
                String path = null; //save path
                JFileChooser fileChooser = new JFileChooser(); //Open dialog
                fileChooser.setDialogTitle("Specify a name to save"); //this will be the title
                int userSelection = fileChooser.showSaveDialog(null); //getting the value of the button user clicked, is it save or cancel button
                
                if(userSelection == JFileChooser.APPROVE_OPTION) { //if it is save button then
                    File fileToSave = fileChooser.getSelectedFile(); //getting the file 
                    if(fileToSave.getAbsolutePath().toLowerCase().endsWith(".json")){ //if the name of the file ends with .json then
                        path = fileToSave.getAbsolutePath(); //the absolute path is the only need
                    } else  {
                        path = fileToSave.getAbsolutePath() + ".json"; //if not, we need to add .json in the end
                    }
                }
                
                FileWriter file = new FileWriter(path); //writing the path, it will be empty for now
                file.write(obj.toJSONString()); //writing the JSONObject as a string
                file.flush(); //when write data, it is not instantly written, but written in buffer temporarily. flush() forces data written from buffer. It improves i/o performance
                JOptionPane.showMessageDialog(null, "Done"); //then showing done to the user
            } catch (IOException e) {
                e.printStackTrace();
            } 
        } else {
            JOptionPane.showMessageDialog(null, "Must Have Data on the Table!");
        }
    }//GEN-LAST:event_SaveButtonActionPerformed

    
    public void ConfigurationStarter() throws FacebookException{
        
        GetCredentials g = new GetCredentials();  //will be used for getting appid and appsecret
     // Create conf builder and set authorization and access keys
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder(); //new configuration object
        //entering configuration that are needed
        configurationBuilder.setDebugEnabled(true);
        configurationBuilder.setOAuthAppId(g.GetAppId());
        configurationBuilder.setOAuthAppSecret(g.GetAppSecret());
        configurationBuilder.setOAuthAccessToken(AccessToken);
        configurationBuilder.setOAuthPermissions("email, publish_stream, id, name, first_name, last_name, read_stream , generic");
        configurationBuilder.setUseSSL(true);
        configurationBuilder.setJSONStoreEnabled(true);

        // Create configuration and get Facebook instance
        Facebook facebook = new FacebookFactory(configurationBuilder.build()).getInstance();

        String searchPost = GroupId; //data will be fetcehd from here
        getFacebookPostes(facebook, searchPost); //fetch data using this configuration and group/page id
 }

    // This method is used to get Facebook posts based on the search string sent below
    public void getFacebookPostes(Facebook facebook, String searchPost)
                    throws FacebookException {
            
            SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd"); //for date in the table
            
            row = (DefaultTableModel)ResultTable.getModel(); //default table model has add, delete update etc method already written. 
            int i = 1; //starting row number
            int noOfpost = Integer.parseInt(NoOfPosts.getText()); //no of post asked by user
            int NoOfPostsToBeFetched = 100; //limit to fetch at once = 100
            int currentPos = 0; //current offset of facebook post, current offset=0 means most recent post, 100 means posts except most recent 100 posts
            while(true){
                try{
                    facebook4j.ResponseList<Post> results =  facebook.getPosts(searchPost, new Reading().limit(NoOfPostsToBeFetched).offset(currentPos)); //getting 100 posts at once and saving it in ResponseList named results
                    for(Post post : results) { //looping through all posts
                            row.addRow(new Object[]{i++, post.getMessage(), DateFormat.format(post.getCreatedTime()), post.getId()}); //adding a row for each posts
                    }
                    currentPos += 100;  //recent 100 post will be ignored
                    if(noOfpost - currentPos < 100 && noOfpost - currentPos != 0){ //at last stage ex 30 remaining of 330 required posts
                        NoOfPostsToBeFetched = noOfpost - currentPos; //at last stage, limit will not be 100 but less 
                    } else if(noOfpost - currentPos == 0){ //if required posts is like 200 or 300 i.e. noOfpost - currentPos = 100 then break cause we fetched all the data
                        break;
                    }
                } catch(FacebookException e){
                    e.printStackTrace();
                    break;
                }
            }
            IsTableLoaded = true; //data has been loaded on table
	}



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AccessTokenField;
    private javax.swing.JLabel AccessTokenLabel;
    private javax.swing.JButton BacktoMenuButton;
    private javax.swing.JTextField GroupIdField;
    private javax.swing.JLabel GroupIdLabel;
    private javax.swing.JTextField NoOfPosts;
    private javax.swing.JTable ResultTable;
    private javax.swing.JButton SaveButton;
    private javax.swing.JButton SearchButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
