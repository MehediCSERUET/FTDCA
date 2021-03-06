/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ftdca;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Logger;
import java.util.logging.Level;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import javax.swing.*;
import javax.swing.table.*;
/**
 *
 * @author Mehedi Hasan
 */
public class TwitterResult extends javax.swing.JFrame {
    
    private String Hashtag;
    private int NoOfTweets;
    private JSONObject obj;
    private JSONArray list;
    private boolean IsTableLoaded = false; //flag to check if there is data present on the table
    
    /**
     * Creates new form TwitterResult
     */
    public TwitterResult() {
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

        HashTagLabel = new javax.swing.JLabel();
        HashTagField = new javax.swing.JTextField();
        SearchButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ResultTable = new javax.swing.JTable();
        BackToMenuButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        NoOfTweetsField = new javax.swing.JTextField();
        SaveButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(3840, 2160));
        setMinimumSize(new java.awt.Dimension(1200, 700));
        setPreferredSize(new java.awt.Dimension(1200, 700));

        HashTagLabel.setFont(new java.awt.Font("Lucida Calligraphy", 0, 14)); // NOI18N
        HashTagLabel.setText("Enter Hashtag");

        SearchButton.setFont(new java.awt.Font("Lucida Calligraphy", 0, 14)); // NOI18N
        SearchButton.setText("Search");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

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

        BackToMenuButton.setFont(new java.awt.Font("Lucida Calligraphy", 0, 14)); // NOI18N
        BackToMenuButton.setText("Menu");
        BackToMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackToMenuButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Calligraphy", 0, 14)); // NOI18N
        jLabel1.setText("Enter no of tweets");

        NoOfTweetsField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoOfTweetsFieldActionPerformed(evt);
            }
        });

        SaveButton.setFont(new java.awt.Font("Lucida Calligraphy", 0, 14)); // NOI18N
        SaveButton.setText("Save");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(BackToMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(HashTagLabel)
                .addGap(8, 8, 8)
                .addComponent(HashTagField, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NoOfTweetsField, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SaveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(27, 27, 27))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HashTagField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HashTagLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BackToMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NoOfTweetsField)
                    .addComponent(SearchButton)
                    .addComponent(SaveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        if(HashTagField.getText().isEmpty() || NoOfTweetsField.getText().isEmpty()){ //if any/both of them is empty
            JOptionPane.showMessageDialog(null, "Must insert all values!"); //show this
        } else {
            Hashtag = HashTagField.getText(); //get hashtag
            NoOfTweets = Integer.parseInt(NoOfTweetsField.getText()); //get no of tweets to retieve
            try{
                   obj = new JSONObject(); //data will be saved as json object
                   list = new JSONArray(); //data will be organized as json array
                   this.ConfigurationStarter(); //configure twitter
                } catch(Exception ex){
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }//GEN-LAST:event_SearchButtonActionPerformed

    private void NoOfTweetsFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoOfTweetsFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NoOfTweetsFieldActionPerformed

    private void BackToMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackToMenuButtonActionPerformed
       this.setVisible(false);
       Menu menu = new Menu();
       menu.setVisible(true);
    }//GEN-LAST:event_BackToMenuButtonActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
     if(IsTableLoaded){ //if table is filled with data
            try {
                obj.put("data", list); //key->data value->json array
                
                String path = null; //path where data will be saved
                JFileChooser fileChooser = new JFileChooser(); //ilechooser object
                fileChooser.setDialogTitle("Specify a name to save"); //title of jfilechooser
                int userSelection = fileChooser.showSaveDialog(null); //after save/cancel button click performed, an int value is returned
                
                if(userSelection == JFileChooser.APPROVE_OPTION) { //if it is save button then
                    File fileToSave = fileChooser.getSelectedFile(); //get the file saved by the user
                    if(fileToSave.getAbsolutePath().toLowerCase().endsWith(".json")){ //check if ends with .json or not
                        path = fileToSave.getAbsolutePath(); //if yes, it is the desired path
                    } else  {
                        path = fileToSave.getAbsolutePath() + ".json"; //else, add .json in the end
                    }
                }
                
                FileWriter file = new FileWriter(path); //the name of the file which will be saved
                file.write(obj.toJSONString()); //writing the JSONObject as a string
                file.flush(); //when write data, it is not instantly written, but written in buffer temporarily. flush() forces data written from buffer. It improves i/o performance
                JOptionPane.showMessageDialog(null, "Done");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_SaveButtonActionPerformed
   
    
    public void ConfigurationStarter() throws Exception{
        DefaultTableModel row = (DefaultTableModel)ResultTable.getModel(); //creating the model of the table to which new row will be added

        //getting credentials
        GetCredentials g = new GetCredentials();

        // Create configuration builder and set key, token etc
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setOAuthConsumerKey(g.GetConsumerKey());
        cb.setOAuthConsumerSecret(g.GetConsumerKeySecret());
        cb.setOAuthAccessToken(g.GetAccessToken());
        cb.setOAuthAccessTokenSecret(g.GetAccessTokenSecret());

        Twitter twitter = new TwitterFactory(cb.build()).getInstance();
        
        SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Query query = new Query(Hashtag); //query is used to get tweet based on hashtag
        int numberOfTweets = NoOfTweets; //no of tweets to be collected
        long lastID = Long.MAX_VALUE;  //used to store the last tweet id, it will get more than 100 tweets
        ArrayList<Status> tweets = new ArrayList<Status>();//stores the tweets
        int temp = -1; //to break out of infiity loop
        while (tweets.size() < numberOfTweets) { //when the number of tweets retrieved is less than the desired number
            if(temp == tweets.size()){ //if it is stuck producing same tweet over and over
                break; 
            } else {
                temp = tweets.size(); //save the number
            }
            temp = tweets.size(); 
          if (numberOfTweets - tweets.size() > 100) //after 100 tweets retrival
            query.setCount(100); //set query for the next 100 tweets if more than 100 tweets still needed to be fetched
          else 
            query.setCount(numberOfTweets - tweets.size()); //set query equal whatever remaining no of tweets to be fetched, ex: 88
          try {
            QueryResult result = twitter.search(query); //gettng the tweets here
            tweets.addAll(result.getTweets()); //adding the tweets
            for (Status t: tweets)  //looping through the tweets
              if(t.getId() < lastID) //getting the last tweet id of this current batch of tweets
                  lastID = t.getId(); //setting the last id of the tweets that has been fetched
          }
          catch (TwitterException te) {
            System.out.println("Couldn't connect: " + te);
          } 
          query.setMaxId(lastID-1); //setting the max id to the last tweeet id that has been retrieved
        }

        for (int i = 0; i < tweets.size(); i++) { //looping through all the tweets that has been fetched
          Status t = (Status) tweets.get(i); //get a tweet
          String msg = t.getText(); //get the tweet text
          String id = Long.toString(t.getId()); //get tweet id
          row.addRow(new Object[]{i+1, msg, DateFormat.format(t.getCreatedAt()), id}); //adding into the table
          
          //adding into json
          list.add(msg);
          list.add(DateFormat.format(t.getCreatedAt()));
          list.add(id);
          IsTableLoaded = true; //setting the flag
     } 
    

}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackToMenuButton;
    private javax.swing.JTextField HashTagField;
    private javax.swing.JLabel HashTagLabel;
    private javax.swing.JTextField NoOfTweetsField;
    private javax.swing.JTable ResultTable;
    private javax.swing.JButton SaveButton;
    private javax.swing.JButton SearchButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
