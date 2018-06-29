/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ftdca;

import java.io.*;
import java.sql.*;
import java.text.*;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Mehedi Hasan
 */
public class JSON2MySQL extends javax.swing.JFrame {
    
    private int i = 1;
    private DefaultTableModel row;
    private boolean IsTableLoaded = false;
    private JSONObject obj;
    private JSONParser parser;
    private JSONArray list;
    private String TableName;

    //for database
    Connection cn=null;
    Statement stmt=null;
    ResultSet res=null;
    String driver="com.mysql.jdbc.Driver";
    String url="jdbc:mysql://localhost:3306/ftdca";
    
    /**
     * Creates new form JSON2MySQL
     */
    public JSON2MySQL() {
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
        ChooseFile = new javax.swing.JButton();
        BackToMenuButton = new javax.swing.JButton();
        SaveButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        ClearTableButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        TableNameField = new javax.swing.JTextField();
        ExecuteButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        ConditionField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(3840, 2160));
        setMinimumSize(new java.awt.Dimension(1200, 700));
        setPreferredSize(new java.awt.Dimension(1200, 700));

        jLabel1.setFont(new java.awt.Font("Lucida Calligraphy", 0, 14)); // NOI18N
        jLabel1.setText("Load JSON");

        ChooseFile.setFont(new java.awt.Font("Lucida Calligraphy", 0, 14)); // NOI18N
        ChooseFile.setText("Choose");
        ChooseFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChooseFileActionPerformed(evt);
            }
        });

        BackToMenuButton.setFont(new java.awt.Font("Lucida Calligraphy", 0, 14)); // NOI18N
        BackToMenuButton.setText("Back To Menu");
        BackToMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackToMenuButtonActionPerformed(evt);
            }
        });

        SaveButton.setFont(new java.awt.Font("Lucida Calligraphy", 0, 14)); // NOI18N
        SaveButton.setText("Save as JSON");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Posts", "Date", "PostId"
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
        Table.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(Table);
        Table.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (Table.getColumnModel().getColumnCount() > 0) {
            Table.getColumnModel().getColumn(0).setPreferredWidth(35);
            Table.getColumnModel().getColumn(1).setPreferredWidth(1040);
            Table.getColumnModel().getColumn(2).setPreferredWidth(75);
            Table.getColumnModel().getColumn(3).setPreferredWidth(50);
        }

        ClearTableButton.setFont(new java.awt.Font("Lucida Calligraphy", 0, 14)); // NOI18N
        ClearTableButton.setText("Clear Table");
        ClearTableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearTableButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lucida Calligraphy", 0, 14)); // NOI18N
        jLabel2.setText("SELECT * FROM");

        ExecuteButton.setFont(new java.awt.Font("Lucida Calligraphy", 0, 14)); // NOI18N
        ExecuteButton.setText("Execute");
        ExecuteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExecuteButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        jLabel3.setText("WHERE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TableNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ChooseFile, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ClearTableButton)
                        .addGap(168, 168, 168)
                        .addComponent(BackToMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(148, 148, 148))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(40, 40, 40)
                        .addComponent(ConditionField, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SaveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ExecuteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(ChooseFile, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BackToMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ClearTableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ExecuteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ConditionField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TableNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackToMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackToMenuButtonActionPerformed
        Menu menu = new Menu();
        this.setVisible(false);
        menu.setVisible(true);
    }//GEN-LAST:event_BackToMenuButtonActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        if(IsTableLoaded){  //checking if the data exist on the table
            obj = new JSONObject(); //need a json object to save data
            list = new JSONArray();  //saving in a json array format
            int r = row.getRowCount(); //total number of data in the table
            for(int m = 0; m < r; m++){ //looping through the data
                if(row.getValueAt(m, 1)!= null){ //is the data empty? if not
                    list.add(row.getValueAt(m, 1)); //always ignore 1st column which contains id
                    list.add(row.getValueAt(m, 2)); //add the data into json array
                    list.add(row.getValueAt(m, 3));
                }
            }
            try {
                obj.put("data", list); //key->data, value->json array
                
                String path = null; //path to save data
                JFileChooser fileChooser = new JFileChooser(); //create a jfilchooser object
                fileChooser.setDialogTitle("Specify a name to save"); //this is the title
                int userSelection = fileChooser.showSaveDialog(null);  //what option user chose
                
                if(userSelection == JFileChooser.APPROVE_OPTION) { //If the save button is clicked
                    File fileToSave = fileChooser.getSelectedFile();  //select the chosen file which will be filled with data
                    if(fileToSave.getAbsolutePath().toLowerCase().endsWith(".json")){ //if the user added .json in the end
                        path = fileToSave.getAbsolutePath(); //the absolute path is the path to be written the data with
                    } else  { //if user didn't add .json
                        path = fileToSave.getAbsolutePath() + ".json";  //add .json in the end
                    }
                }
                
                FileWriter file = new FileWriter(path); //the name of the file which will be saved
                file.write(obj.toJSONString()); //writing the JSONObject as a string
                file.flush(); //when write data, it is not instantly written, but written in buffer temporarily. flush() forces data written from buffer. It improves i/o performance
                JOptionPane.showMessageDialog(null, "Done");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "No data on Table!");
        }
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void ChooseFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChooseFileActionPerformed
        JFileChooser chooser = new JFileChooser(); //creating filechooser object
        chooser.showOpenDialog(null); //showing the dialog box
        File f = chooser.getSelectedFile(); //gettting the selected file
        row = (DefaultTableModel)Table.getModel();  //accessing the table
        parser = new JSONParser(); //parser is used to parse the json file
        String post,date, tableName = f.getName().replace(".json", ""), id; //name of the mysql table will be the filename except extension
        try {
            Object obj = parser.parse(new FileReader(f)); //parsing the json file
            IsTableLoaded = true; //flag is true as data will be filled shortly
            TableName = tableName; //it will be sent to mysql
            JSONObject jsonObject = (JSONObject) obj; //typecasting the object as jsonObject
            JSONArray msg = (JSONArray) jsonObject.get("data"); //getting the jsonarray which has the key "data"
            Iterator<String> iterator = msg.iterator(); //iterator will be used to iterate through the json array
            while (iterator.hasNext()) { //while json array is not empty
                post = iterator.next(); //getting the post which was written first
                date = iterator.next(); //date was written second
                id = iterator.next(); //at last post id was written
                row.addRow(new Object[]{i++, post, date, id}); //adding a row
                if(post != null && !post.isEmpty() && !date.isEmpty()){ //if not null opr empty
                    AddIntoMySQL(tableName, post, date, id); //adding into mysql table
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException ex) {
            Logger.getLogger(PreProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ChooseFileActionPerformed

    private void ClearTableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearTableButtonActionPerformed
        if(IsTableLoaded){ //if the table has data on it
            try{
                while(row.getRowCount() != 0){ //untill there is no row
                    row.removeRow(row.getRowCount() - 1); //delete the last row
                }
                i = 1; 
                IsTableLoaded = false; //flag is false as table cleared
                
                //creating a connection
                cn = DriverManager.getConnection(url,"root","");         
                //create statement
                stmt=cn.createStatement();
                String DeleteTable = "DROP TABLE `"+TableName+"`";
                stmt.execute(DeleteTable); //dropping the table from mysql as well
                
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_ClearTableButtonActionPerformed

    private void ExecuteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExecuteButtonActionPerformed

        if(TableNameField.getText().isEmpty() || ConditionField.getText().isEmpty()){ //if any of them is empty
            JOptionPane.showMessageDialog(null, "Please Insert a Query!"); //showing this
        } else {
            try{
                //creating a connection
                cn = DriverManager.getConnection(url,"root","");         
                //create statement
                stmt=cn.createStatement(); //statement is used to carry out query
                String query = "SELECT * FROM `"+TableNameField.getText()+"` WHERE "+ConditionField.getText()+";";
                ResultSet rs = stmt.executeQuery(query); //select returns a resultSet
                //clear table
                while(row.getRowCount() != 0){ 
                    row.removeRow(row.getRowCount() - 1);
                }
                i = 1;
                //table cleared

                //entering new data from sql result
                while(rs.next()){ //while result set has data left
                    //getting the info from mysql using column name
                    int j = rs.getInt("ID");
                    String post = rs.getString("Posts");
                    String date = rs.getDate("Date").toString();
                    String postId = rs.getString("PostId");
                    row.addRow(new Object[]{j, post, date, postId}); //adding a new row
                }
                IsTableLoaded = true;
            } catch(Exception ex) {
                    ex.printStackTrace();
            }
        }    
    }//GEN-LAST:event_ExecuteButtonActionPerformed

    public void AddIntoMySQL(String TableName, String Post, String d, String PostId){
         //trying to register into database
            try{
                //creating a connection
                cn = DriverManager.getConnection(url,"root","");         
                //create statement
                stmt=cn.createStatement();                               
                
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                Date d1 = df.parse(d);  //as date was sent as string and it needs to be converted into date type
             
                String TableStructure = "CREATE TABLE IF NOT EXISTS `"+TableName+"` (  `ID` int(10) NOT NULL AUTO_INCREMENT,  `Posts` text NOT NULL, `Date` date NOT NULL, `PostId` varchar(100) NOT NULL,  PRIMARY KEY (`ID`)) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;";
                String query = "INSERT INTO `ftdca`.`"+TableName+"` (`ID`, `Posts`, `Date`, `PostId`) VALUES (null, '"+Post.replace("'", "")+"', '"+df.format(d1)+"', '"+PostId+"')";
                
                if(stmt.execute(TableStructure) == false){ //creating the table if not created
                    stmt.execute(query); //inserting the row
                } else {
                    JOptionPane.showMessageDialog(null, "Error occured while creating table "+TableName);
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
    }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackToMenuButton;
    private javax.swing.JButton ChooseFile;
    private javax.swing.JButton ClearTableButton;
    private javax.swing.JTextField ConditionField;
    private javax.swing.JButton ExecuteButton;
    private javax.swing.JButton SaveButton;
    private javax.swing.JTable Table;
    private javax.swing.JTextField TableNameField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
