package com.amdocs.avishkar.voting;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FocusTraversalPolicy;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import jcifs.UniAddress;
import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbAuthException;
import jcifs.smb.SmbException;
import jcifs.smb.SmbSession;

import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.jdesktop.application.SingleFrameApplication;

import com.amdocs.avishkar.db.SaveToDBMySqlWithHibernate;
import com.amdocs.avishkar.db.VoteDt;

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class AvishkarVoting extends SingleFrameApplication {
	private JPanel topPanel;
	private JButton btnSubmit;
	private JPasswordField txtPassword;
	private JLabel lblPassword;
	private JLabel lblAvishkarLogo1;
	private JLabel lblAvishkarLogo2;
	private JLabel lblAvishkarLogo;
	private JPanel pnlSubmit;
	private JPanel pnlRank;
	private JPanel pnlLogin;
	private JLabel lblRank3;
	private JLabel lblRank2;
	private JLabel lblRank1;
	private JLabel lblRank3Title;
	private JLabel lblRank2Title;
	private JLabel lblRank1Title;
	private JButton btnReset;
	private JButton btnLogin;
	private JToggleButton btnIdea7;
	private JToggleButton btnIdea8;
	private JToggleButton btnIdea6;
	private JToggleButton btnIdea5;
	private JToggleButton btnIdea4;
	private JToggleButton btnIdea3;
	private JToggleButton btnIdea2;
	private JToggleButton btnIdea1;
	private JTextField txtEmpNtnetId;
	private JLabel lblEmpNtnetId;
	private JPanel votePanel;

	private long rank1;
	private long rank2;
	private long rank3;

	private int clickCounter;

	
	private JToggleButton btnIdea12;
	private JToggleButton btnIdea11;
	private JToggleButton btnIdea10;
	private JToggleButton btnIdea9;
	private final static long idea1= 11200;
	private final static long idea2= 13106;
	private final static long idea3= 13423;
	private final static long idea4= 13517;
	private final static long idea5= 13707;
	private final static long idea6= 13912;
	private final static long idea7= 14115;
	private final static long idea8= 14117;
	private final static long idea9= 14316;
	private final static long idea10= 14323;
	private final static long idea11= 14344;
	private final static long idea12= 14391;	
	
	private final static String idea1_text = "#11200 - Automated CRM Environment Setup";
	private final static String idea2_text = "#13106 - Virtual Chat Agent";
	private final static String idea3_text = "#13423 - Smart UI Migrator";
	private final static String idea4_text = "#13517 - Mr. FIXIT";
	private final static String idea5_text = "#13707 - RSS Feeds into CRM";
	private final static String idea6_text = "#13912 - Unified Monitoring & Control";
	private final static String idea7_text = "#14115 - Java Monitoring & Control";
	private final static String idea8_text = "#14117 - CRM Upgrade Toolkit";
	private final static String idea9_text = "#14316 - Generic Apply-Back Solution";
	private final static String idea10_text = "#14323 - Production Alert Monitor";
	private final static String idea11_text = "#14344 - Speech Enabled CRM";
	private final static String idea12_text = "#14391 - Automated RBMS Installer";

	private final static String LDAP_ADDRESS = "dvcidc01.corp.amdocs.com";
	private final static String DOMAIN = "ntnet";
	
	/*private Connection dbConnection = null;
	private SaveVoteToDB saveVoteToDB = null;*/

	/*private final static String MYSQL_DB_HOST_NAME = "basting01";
	private final static String MYSQL_DB_PORT = "3306";
	private final static String MYSQL_DB_USERNAME = "root";
	private final static String MYSQL_DB_PASSWORD = "password";


	private final static String ORACLE_DB_HOST_NAME = "10.19.168.117";
	private final static String ORACLE_DB_PORT = "1521";
	private final static String ORACLE_DB_SID = "xlcrm25g";
	private final static String ORACLE_DB_USERNAME = "sa";
	private final static String ORACLE_DB_PASSWORD = "sa";

	private final static int ORACLE = 1;
	private final static int MYSQL = 2;
	 */
	// Change the variable 'whichDb' to below variables for changing db : 
	// ORACLE - changes to oracle db. modify the below attributes.
	//		- ORACLE_DB_HOST_NAME
	//  	- ORACLE_DB_PORT
	//  	- ORACLE_DB_SID
	//  	- ORACLE_DB_USERNAME
	//  	- ORACLE_DB_PASSWORD
	// MYSQL - changes to mysql db. modify the below attributes.
	//  	- MYSQL_DB_HOST_NAME
	//  	- MYSQL_DB_PORT
	//  	- MYSQL_DB_USERNAME
	//  	- MYSQL_DB_PASSWORD
	//private final static int whichDb = MYSQL;

	private String ntnetUsername = null;

	private SaveToDBMySqlWithHibernate saveObj = null;
	private Session session = null;

	//Toolkit toolkit = null;
	
	public AvishkarVoting(){
		super();
		saveObj = new SaveToDBMySqlWithHibernate();
		//saveVoteToDB = getSaveVoteToDB(whichDb);
		session = saveObj.getSession();
		
		//toolkit = getMainFrame().getContentPane().getToolkit();
				
	}


	@Override
	protected void startup() {
		topPanel = new JPanel();
		CardLayout mainFrameLayout = new CardLayout();
		getMainFrame().getContentPane().setLayout(mainFrameLayout);
		getMainFrame().addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				mainFrameWindowClosing(evt);
			}
		});
		getMainFrame().getContentPane().add(topPanel, "North");
		GroupLayout topPanelLayout = new GroupLayout((JComponent)topPanel);
		topPanel.setLayout(topPanelLayout);
		topPanel.setPreferredSize(new java.awt.Dimension(606, 412));
		topPanel.setName("topPanel");
		{
			votePanel = new JPanel();
			getMainFrame().getContentPane().add(votePanel, "jPanel1");
			GroupLayout votePanelLayout = new GroupLayout((JComponent)votePanel);
			votePanel.setLayout(votePanelLayout);
			votePanel.setName("votePanel");
			votePanel.setPreferredSize(new java.awt.Dimension(830, 564));
			{
				btnIdea1 = new JToggleButton();
				btnIdea1.setName("btnIdea1");        		
				btnIdea1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnIdea1ActionPerformed(evt);
					}
				});
			}
			{
				pnlSubmit = new JPanel();
				GroupLayout pnlSubmitLayout = new GroupLayout((JComponent)pnlSubmit);
				pnlSubmit.setLayout(pnlSubmitLayout);
				pnlSubmit.setBorder(BorderFactory.createTitledBorder(null, "Vote/Reset", TitledBorder.LEADING, TitledBorder.TOP));
				{
					btnSubmit = new JButton();
					btnSubmit.setName("btnSubmit");
					btnSubmit.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							btnSubmitActionPerformed(evt);
						}
					});
				}
				{
					btnReset = new JButton();
					btnReset.setName("btnReset");
					btnReset.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							btnResetActionPerformed(evt);
						}					

					});
				}
				pnlSubmitLayout.setHorizontalGroup(pnlSubmitLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnSubmit, 0, 189, Short.MAX_VALUE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					.addComponent(btnReset, 0, 186, Short.MAX_VALUE)
					.addGap(7));
				pnlSubmitLayout.setVerticalGroup(pnlSubmitLayout.createSequentialGroup()
					.addGroup(pnlSubmitLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(btnSubmit, GroupLayout.Alignment.BASELINE, 0, 93, Short.MAX_VALUE)
					    .addComponent(btnReset, GroupLayout.Alignment.BASELINE, 0, 93, Short.MAX_VALUE))
					.addContainerGap());
			}
			{
				pnlRank = new JPanel();
				GroupLayout pnlRankLayout = new GroupLayout((JComponent)pnlRank);
				pnlRank.setLayout(pnlRankLayout);
				pnlRank.setBorder(BorderFactory.createTitledBorder("Selected Ideas"));
				{
					lblRank1Title = new JLabel();
					lblRank1Title.setName("lblRank1Title");
				}
				{
					lblRank2Title = new JLabel();
					lblRank2Title.setName("lblRank2Title");
				}
				{
					lblRank3Title = new JLabel();
					lblRank3Title.setName("lblRank3Title");
				}
				{
					lblRank1 = new JLabel();
					lblRank1.setName("lblRank1");
				}
				{
					lblRank3 = new JLabel();
					lblRank3.setName("lblRank3");
				}
				{
					lblRank2 = new JLabel();
					lblRank2.setName("lblRank2");
				}
				pnlRankLayout.setHorizontalGroup(pnlRankLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(pnlRankLayout.createParallelGroup()
					    .addComponent(lblRank3Title, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					    .addComponent(lblRank1Title, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					    .addComponent(lblRank2Title, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(pnlRankLayout.createParallelGroup()
					    .addComponent(lblRank1, GroupLayout.Alignment.LEADING, 0, 316, Short.MAX_VALUE)
					    .addComponent(lblRank2, GroupLayout.Alignment.LEADING, 0, 316, Short.MAX_VALUE)
					    .addComponent(lblRank3, GroupLayout.Alignment.LEADING, 0, 316, Short.MAX_VALUE))
					.addContainerGap());
				pnlRankLayout.setVerticalGroup(pnlRankLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(pnlRankLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(lblRank1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					    .addComponent(lblRank1Title, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(pnlRankLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(lblRank2, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					    .addComponent(lblRank2Title, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(pnlRankLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(lblRank3, GroupLayout.Alignment.BASELINE, 0, 26, Short.MAX_VALUE)
					    .addComponent(lblRank3Title, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(6));
			}
			{
				btnIdea9 = new JToggleButton();
				btnIdea9.setName("btnIdea9");
				btnIdea9.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnIdea9ActionPerformed(evt);
					}
				});
			}
			{
				btnIdea12 = new JToggleButton();
				btnIdea12.setName("btnIdea12");
				btnIdea12.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnIdea12ActionPerformed(evt);
					}
				});
			}
			{
				btnIdea11 = new JToggleButton();
				btnIdea11.setName("btnIdea11");
				btnIdea11.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnIdea11ActionPerformed(evt);
					}
				});
			}
			{
				btnIdea10 = new JToggleButton();
				btnIdea10.setName("btnIdea10");
				btnIdea10.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnIdea10ActionPerformed(evt);
					}
				});
			}
			{
				btnIdea2 = new JToggleButton();
				btnIdea2.setName("btnIdea2");
				btnIdea2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnIdea2ActionPerformed(evt);
					}

				});
			}
			{
				btnIdea3 = new JToggleButton();
				btnIdea3.setName("btnIdea3");
				btnIdea3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnIdea3ActionPerformed(evt);
					}


				});
			}
			{
				btnIdea4 = new JToggleButton();
				btnIdea4.setName("btnIdea4");
				btnIdea4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnIdea4ActionPerformed(evt);
					}

				});
			}
			{
				btnIdea7 = new JToggleButton();
				btnIdea7.setName("btnIdea7");
				btnIdea7.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnIdea7ActionPerformed(evt);
					}

				});
			}
			{
				btnIdea8 = new JToggleButton();
				btnIdea8.setName("btnIdea8");
				btnIdea8.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnIdea8ActionPerformed(evt);
					}

				});
			}
			{
				btnIdea5 = new JToggleButton();
				btnIdea5.setName("btnIdea5");
				btnIdea5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnIdea5ActionPerformed(evt);
					}

				});
			}
			{
				btnIdea6 = new JToggleButton();
				btnIdea6.setName("btnIdea6");
				btnIdea6.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnIdea6ActionPerformed(evt);
					}

				});
			}
			votePanelLayout.setHorizontalGroup(votePanelLayout.createSequentialGroup()
				.addGap(8)
				.addGroup(votePanelLayout.createParallelGroup()
				    .addGroup(votePanelLayout.createSequentialGroup()
				        .addGroup(votePanelLayout.createParallelGroup()
				            .addComponent(btnIdea9, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
				            .addComponent(btnIdea5, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
				            .addComponent(btnIdea1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))
				        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				        .addGroup(votePanelLayout.createParallelGroup()
				            .addComponent(btnIdea2, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
				            .addComponent(btnIdea6, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
				            .addComponent(btnIdea10, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)))
				    .addComponent(pnlRank, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 405, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(votePanelLayout.createParallelGroup()
				    .addGroup(votePanelLayout.createSequentialGroup()
				        .addComponent(pnlSubmit, GroupLayout.PREFERRED_SIZE, 405, GroupLayout.PREFERRED_SIZE))
				    .addGroup(votePanelLayout.createSequentialGroup()
				        .addGroup(votePanelLayout.createParallelGroup()
				            .addComponent(btnIdea11, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
				            .addComponent(btnIdea7, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
				            .addComponent(btnIdea3, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))
				        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				        .addGroup(votePanelLayout.createParallelGroup()
				            .addGroup(GroupLayout.Alignment.LEADING, votePanelLayout.createSequentialGroup()
				                .addComponent(btnIdea4, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))
				            .addGroup(votePanelLayout.createSequentialGroup()
				                .addComponent(btnIdea8, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))
				            .addGroup(votePanelLayout.createSequentialGroup()
				                .addComponent(btnIdea12, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)))))
				.addContainerGap(12, Short.MAX_VALUE));
			votePanelLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnIdea5, btnIdea9, btnIdea10, btnIdea6, btnIdea2, btnIdea3, btnIdea7, btnIdea11, btnIdea12, btnIdea8, btnIdea4, btnIdea1});
			votePanelLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {pnlRank, pnlSubmit});
			votePanelLayout.setVerticalGroup(votePanelLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(votePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(btnIdea4, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
				    .addComponent(btnIdea3, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
				    .addComponent(btnIdea2, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
				    .addComponent(btnIdea1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(votePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(btnIdea8, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
				    .addComponent(btnIdea7, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
				    .addComponent(btnIdea6, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
				    .addComponent(btnIdea5, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(votePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(btnIdea12, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
				    .addComponent(btnIdea11, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
				    .addComponent(btnIdea10, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
				    .addComponent(btnIdea9, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(votePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				    .addComponent(pnlSubmit, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
				    .addComponent(pnlRank, GroupLayout.Alignment.LEADING, 0, 129, Short.MAX_VALUE))
				.addGap(0, 6, Short.MAX_VALUE));
			votePanelLayout.linkSize(SwingConstants.VERTICAL, new Component[] {pnlRank, pnlSubmit});
			votePanelLayout.linkSize(SwingConstants.VERTICAL, new Component[] {btnIdea5, btnIdea9, btnIdea10, btnIdea6, btnIdea2, btnIdea3, btnIdea7, btnIdea11, btnIdea12, btnIdea8, btnIdea4, btnIdea1});
		}
		{
			pnlLogin = new JPanel();
			GroupLayout pnlLoginLayout = new GroupLayout((JComponent)pnlLogin);
			pnlLogin.setLayout(pnlLoginLayout);
			pnlLogin.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
			pnlLogin.setName("pnlLogin");
			{
				txtEmpNtnetId = new JTextField();
				txtEmpNtnetId.setName("txtEmpNtnetId");
				txtEmpNtnetId.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						txtEmpNtnetIdActionPerformed(evt);
					}
				});
			}
			{
				lblEmpNtnetId = new JLabel();
				lblEmpNtnetId.setName("lblEmpNtnetId");
			}
			{
				btnLogin = new JButton();
				btnLogin.setName("btnLogin");
				btnLogin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnLoginActionPerformed(evt);
					}
				});
			}
			{
				txtPassword = new JPasswordField();
				txtPassword.setName("txtPassword");
				txtPassword.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						txtPasswordActionPerformed(evt);
					}
				});
			}
			{
				lblPassword = new JLabel();
				lblPassword.setName("lblPassword");
			}
			pnlLoginLayout.setHorizontalGroup(pnlLoginLayout.createSequentialGroup()
				.addGap(6)
				.addGroup(pnlLoginLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, pnlLoginLayout.createSequentialGroup()
				        .addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
				        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
				    .addGroup(GroupLayout.Alignment.LEADING, pnlLoginLayout.createSequentialGroup()
				        .addComponent(lblEmpNtnetId, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
				        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
				    .addComponent(txtEmpNtnetId, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
				    .addComponent(txtPassword, GroupLayout.Alignment.LEADING, 0, 184, Short.MAX_VALUE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
				.addContainerGap());
			pnlLoginLayout.setVerticalGroup(pnlLoginLayout.createSequentialGroup()
				.addGap(8)
				.addComponent(lblEmpNtnetId, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
				.addGroup(pnlLoginLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, pnlLoginLayout.createSequentialGroup()
				        .addComponent(txtEmpNtnetId, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				        .addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
				        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 0, Short.MAX_VALUE)
				        .addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
				    .addComponent(btnLogin, GroupLayout.Alignment.LEADING, 0, 76, Short.MAX_VALUE))
				.addContainerGap());
			pnlLogin.setFocusTraversalPolicy(new VotingTraversalPolicy());
		}
		{
			lblAvishkarLogo = new JLabel();
			lblAvishkarLogo.setName("lblAvishkarLogo");
		}
		{
			lblAvishkarLogo2 = new JLabel();
			lblAvishkarLogo2.setName("lblAvishkarLogo2");
		}
		{
			lblAvishkarLogo1 = new JLabel();
			lblAvishkarLogo1.setName("lblAvishkarLogo1");
		}
		topPanelLayout.setVerticalGroup(topPanelLayout.createSequentialGroup()
			.addContainerGap(34, 34)
			.addComponent(lblAvishkarLogo, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
			.addGap(23)
			.addComponent(pnlLogin, 0, 118, Short.MAX_VALUE)
			.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
			.addGroup(topPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			    .addComponent(lblAvishkarLogo2, GroupLayout.Alignment.BASELINE, 0, 264, Short.MAX_VALUE)
			    .addComponent(lblAvishkarLogo1, GroupLayout.Alignment.BASELINE, 0, 264, Short.MAX_VALUE)));
		topPanelLayout.setHorizontalGroup(topPanelLayout.createParallelGroup()
			.addGroup(GroupLayout.Alignment.LEADING, topPanelLayout.createSequentialGroup()
			    .addComponent(lblAvishkarLogo1, 0, 481, Short.MAX_VALUE)
			    .addComponent(lblAvishkarLogo2, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE))
			.addGroup(topPanelLayout.createSequentialGroup()
			    .addGap(97)
			    .addGroup(topPanelLayout.createParallelGroup()
			        .addGroup(topPanelLayout.createSequentialGroup()
			            .addComponent(lblAvishkarLogo, GroupLayout.PREFERRED_SIZE, 651, GroupLayout.PREFERRED_SIZE)
			            .addGap(0, 0, Short.MAX_VALUE))
			        .addGroup(GroupLayout.Alignment.LEADING, topPanelLayout.createSequentialGroup()
			            .addGap(172)
			            .addComponent(pnlLogin, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
			            .addGap(0, 229, Short.MAX_VALUE)))
			    .addContainerGap(82, 82)));

		show(topPanel);
		mainFrameLayout.next(getMainFrame().getContentPane());
		setFocusOnLoginNameTxtBox();
		//pack();		
	}

	private void setFocusOnLoginNameTxtBox(){
		txtEmpNtnetId.requestFocus();
	}
	
	public static void main(String[] args) {
		launch(AvishkarVoting.class, args);
	}

	private void btnResetActionPerformed(ActionEvent evt) {
		enableAllVotingButtons();
		unSelectAllButtons();
		clearLabels();
		clickCounter = 0;
	}

	private void btnIdea12ActionPerformed(ActionEvent evt) {
		System.out.println("btnIdea12.actionPerformed, event="+evt);
		btnIdea12.setEnabled(false);
		setRank(idea12,idea12_text);
	}

	private void btnIdea11ActionPerformed(ActionEvent evt) {
		System.out.println("btnIdea11.actionPerformed, event="+evt);
		btnIdea11.setEnabled(false);
		setRank(idea11,idea11_text);
	}

	private void btnIdea10ActionPerformed(ActionEvent evt) {
		System.out.println("btnIdea10.actionPerformed, event="+evt);
		btnIdea10.setEnabled(false);
		setRank(idea10,idea10_text);
	}


	private void btnIdea9ActionPerformed(ActionEvent evt) {
		System.out.println("btnIdea9.actionPerformed, event="+evt);
		btnIdea9.setEnabled(false);
		setRank(idea9,idea9_text);
	}

	private void btnIdea8ActionPerformed(ActionEvent evt) {
		System.out.println("btnIdea8.actionPerformed, event="+evt);
		btnIdea8.setEnabled(false);
		setRank(idea8,idea8_text);
	}

	private void btnIdea7ActionPerformed(ActionEvent evt) {
		System.out.println("btnIdea7.actionPerformed, event="+evt);
		btnIdea7.setEnabled(false);
		setRank(idea7,idea7_text);
	}

	private void btnIdea6ActionPerformed(ActionEvent evt) {
		System.out.println("btnIdea6.actionPerformed, event="+evt);
		btnIdea6.setEnabled(false);
		setRank(idea6,idea6_text);
	}

	private void btnIdea5ActionPerformed(ActionEvent evt) {
		System.out.println("btnIdea5.actionPerformed, event="+evt);
		btnIdea5.setEnabled(false);
		setRank(idea5,idea5_text);
	}

	private void btnIdea4ActionPerformed(ActionEvent evt) {
		System.out.println("btnIdea4.actionPerformed, event="+evt);
		btnIdea4.setEnabled(false);
		setRank(idea4,idea4_text);
	}

	private void btnIdea3ActionPerformed(ActionEvent evt) {
		System.out.println("btnIdea3.actionPerformed, event="+evt);
		btnIdea3.setEnabled(false);
		setRank(idea3,idea3_text);    	
	}

	private void btnIdea2ActionPerformed(ActionEvent evt) {
		System.out.println("btnIdea2.actionPerformed, event="+evt);
		btnIdea2.setEnabled(false);
		setRank(idea2,idea2_text);
	}

	private void btnIdea1ActionPerformed(ActionEvent evt) {
		System.out.println("btnIdea1.actionPerformed, event="+evt);
		btnIdea1.setEnabled(false);
		setRank(idea1,idea1_text);
	}

	private void setRank(long ideaNo, String ideaText){
		clickCounter ++;
		if(clickCounter == 1){
			lblRank1.setText(ideaText);
			setRank1(ideaNo);
		}else if(clickCounter == 2){
			lblRank2.setText(ideaText);
			setRank2(ideaNo);
		}else{
			lblRank3.setText(ideaText);
			setRank3(ideaNo);
		}
		if(clickCounter == 3){
			disableAllVotingButtons();
		}
	}

	private void disableAllVotingButtons() {
		btnIdea1.setEnabled(false);
		btnIdea2.setEnabled(false);
		btnIdea3.setEnabled(false);
		btnIdea4.setEnabled(false);
		btnIdea5.setEnabled(false);
		btnIdea6.setEnabled(false);
		btnIdea7.setEnabled(false);
		btnIdea8.setEnabled(false);
		btnIdea9.setEnabled(false);
		btnIdea10.setEnabled(false);
		btnIdea11.setEnabled(false);
		btnIdea12.setEnabled(false);		
	}

	private void enableAllVotingButtons() {
		btnIdea1.setEnabled(true);
		btnIdea2.setEnabled(true);
		btnIdea3.setEnabled(true);
		btnIdea4.setEnabled(true);
		btnIdea5.setEnabled(true);
		btnIdea6.setEnabled(true);
		btnIdea7.setEnabled(true);
		btnIdea8.setEnabled(true);
		btnIdea9.setEnabled(true);
		btnIdea10.setEnabled(true);
		btnIdea11.setEnabled(true);
		btnIdea12.setEnabled(true);
		
	}

	private void unSelectAllButtons(){
		btnIdea1.setSelected(false);
		btnIdea2.setSelected(false);
		btnIdea3.setSelected(false);
		btnIdea4.setSelected(false);
		btnIdea5.setSelected(false);
		btnIdea6.setSelected(false);
		btnIdea7.setSelected(false);
		btnIdea8.setSelected(false);
		btnIdea9.setSelected(false);
		btnIdea10.setSelected(false);
		btnIdea11.setSelected(false);
		btnIdea12.setSelected(false);		
	}

	private void clearLabels(){
		lblRank1.setText(null);
		lblRank2.setText(null);
		lblRank3.setText(null);
	}

	public long getRank1() {
		return rank1;
	}

	public void setRank1(long rank1) {
		this.rank1 = rank1;
	}

	public long getRank2() {
		return rank2;
	}

	public void setRank2(long rank2) {
		this.rank2 = rank2;
	}

	public long getRank3() {
		return rank3;
	}

	public void setRank3(long rank3) {
		this.rank3 = rank3;
	}

	private void btnSubmitActionPerformed(ActionEvent evt) {
		System.out.println("btnSubmit.actionPerformed, event="+evt);

		if(clickCounter != 3){
			JOptionPane.showMessageDialog(votePanel,"3 ideas should be selected - Rank 1, Rank 2 and Rank 3");
			return;
		}

		if(session == null){
			JOptionPane.showMessageDialog(votePanel,"Error while trying to cast vote","Fatal Error",JOptionPane.ERROR_MESSAGE);
			return;
		}

		VoteDt voteDt = new VoteDt();
		voteDt.setNtnetUser(ntnetUsername);
		voteDt.setRank1IdeaNo(getRank1());
		voteDt.setRank2IdeaNo(getRank2());
		voteDt.setRank3IdeaNo(getRank3());

		String hostname = "";
		try { 
			InetAddress addr = InetAddress.getLocalHost(); 
			// Get hostname 
			hostname = addr.getHostName(); 
		} catch (UnknownHostException e) { 
			System.out.print("error while getting hostname: "+e.getMessage());
		} 
		
		voteDt.setHostAddr(hostname);
		

		//int status = 
		try{
			saveObj.saveVote(session, voteDt);
			getMainFrame().getContentPane().getToolkit().beep();
			JOptionPane.showMessageDialog(votePanel,"Vote casted successfully");
		}catch(ConstraintViolationException e){
			JOptionPane.showMessageDialog(votePanel,"Your vote was previously casted.","Error",JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();			
		}
		/*if(status == SaveDBConstants.SUCCESS){

		}else if(status == SaveDBConstants.DUPLICATE_ENTRY){
			JOptionPane.showMessageDialog(votePanel,"Your vote was previously casted.","Error",JOptionPane.ERROR_MESSAGE);
		}*/ 

		btnReset.doClick();
		resetTxtFields();

		Container contentPane = getMainFrame().getContentPane();
		CardLayout cardLayoutMgr = (CardLayout)contentPane.getLayout();
		cardLayoutMgr.next(contentPane);
		
		setFocusOnLoginNameTxtBox();
	}

//	@Override
	/*protected void finalize() throws Throwable {
		System.out.println("in finalize");
		super.finalize();
		saveObj.closeSession(session);
	}*/	

	private void resetTxtFields(){
		txtEmpNtnetId.setText(null);
		txtPassword.setText(null);
	}
	
	private void btnLoginActionPerformed(ActionEvent evt) {

		System.out.println("btnLogin.actionPerformed, event="+evt);

		//testThis();

		ntnetUsername = txtEmpNtnetId.getText();
		String pwd = String.valueOf(txtPassword.getPassword());
		if("".equalsIgnoreCase(ntnetUsername.trim())){
			JOptionPane.showMessageDialog(topPanel,"Please enter Ntnet username");
			setFocusOnLoginNameTxtBox();
			return;
		}

		//boolean isValidNtnetId = saveObj.isValidNtnetId(session, ntnetUsername);
		
		String result = authenticate(ntnetUsername,pwd);

		if(!"".equals(result)){
			JOptionPane.showMessageDialog(votePanel,result,"Error",JOptionPane.ERROR_MESSAGE);
			resetTxtFields();
			setFocusOnLoginNameTxtBox();
			return;
		}

		boolean success = isNewUser(ntnetUsername);

		if(!success){
			resetTxtFields();
			setFocusOnLoginNameTxtBox();
			return;
		}

		Container contentPane = getMainFrame().getContentPane();
		CardLayout cardLayoutMgr = (CardLayout)contentPane.getLayout();
		cardLayoutMgr.next(contentPane);
	}

	/*private void testThis() {

		VoteDt voteDt = new VoteDt();
		voteDt.setNtnetUser(txtEmpNtnetId.getText());
		voteDt.setRank1IdeaNo(13106L);
		voteDt.setRank2IdeaNo(13517L);
		voteDt.setRank3IdeaNo(14316L);
		saveObj.saveVote(session,voteDt);
		System.out.println(saveObj.doesUserExistsInDB(session, "basting"));
		System.out.println(saveObj.isValidNtnetId(session, "basting"));

	}*/


	private boolean isNewUser(String ntnetUsername) {

		if(session == null){
			JOptionPane.showMessageDialog(votePanel,"Error while trying to login","Fatal Error",JOptionPane.ERROR_MESSAGE);
			return false;
		}

		boolean userExist = saveObj.doesUserExistsInDB(session, ntnetUsername);

		if(userExist){
			JOptionPane.showMessageDialog(votePanel,"Your vote is already cast.","Error",JOptionPane.ERROR_MESSAGE);
		}

		return !userExist;
	}


	/*public SaveVoteToDB getSaveVoteToDB(int whichDb){
		SaveVoteToDB saveVoteToDB = null;
		if(whichDb == ORACLE){
			SaveVoteToDBWithOracle saveVoteToDBWithOracle = new SaveVoteToDBWithOracle();
			if(dbConnection == null){
				saveVoteToDBWithOracle.setHostname(ORACLE_DB_HOST_NAME); 
				saveVoteToDBWithOracle.setPort(ORACLE_DB_PORT); 
				saveVoteToDBWithOracle.setDbSID(ORACLE_DB_SID); 
				saveVoteToDBWithOracle.setDbUsername(ORACLE_DB_USERNAME); 
				saveVoteToDBWithOracle.setDbPassword(ORACLE_DB_PASSWORD);
				dbConnection = saveVoteToDBWithOracle.getConnection();				
			}
			saveVoteToDB = saveVoteToDBWithOracle;
		}else if(whichDb == MYSQL){
			SaveVoteToDBWithMySQL saveVoteToDBWithMySQL = new SaveVoteToDBWithMySQL();
			if(dbConnection == null){
				saveVoteToDBWithMySQL.setHostname(MYSQL_DB_HOST_NAME);
				saveVoteToDBWithMySQL.setDbPort(MYSQL_DB_PORT); 
				saveVoteToDBWithMySQL.setUsername(MYSQL_DB_USERNAME); 
				saveVoteToDBWithMySQL.setPassword(MYSQL_DB_PASSWORD);
				dbConnection = saveVoteToDBWithMySQL.getConnection();				
			}			
			saveVoteToDB = saveVoteToDBWithMySQL;
		}
		return saveVoteToDB;
	}

	public void closeConn(){
		if(saveVoteToDB != null){
			saveVoteToDB.closeConnection(dbConnection);
		}
	}*/

	private void mainFrameWindowClosing(WindowEvent evt) {
		System.out.println("getMainFrame().windowClosing, event="+evt);
		//closeConn();
		saveObj.closeSession(session);
	}
	
	private void txtEmpNtnetIdActionPerformed(ActionEvent evt) {
		System.out.println("txtEmpNtnetId.actionPerformed, event="+evt);
		btnLogin.doClick();
	}
	
	public String authenticate(String username, String password){
		try {
			UniAddress mydomaincontroller = UniAddress.getByName(LDAP_ADDRESS);
			NtlmPasswordAuthentication mycreds = new NtlmPasswordAuthentication(DOMAIN, username,password);
			SmbSession.logon( mydomaincontroller, mycreds );
			return "";
		} catch( SmbAuthException sae ) {
			sae.printStackTrace();
		    return sae.getMessage();
		} catch( SmbException se ) {
		    se.printStackTrace();
		    return se.getMessage();
		} catch (UnknownHostException e) {
			e.printStackTrace();
			return e.getMessage();
		}		
	}
	
	private void txtPasswordActionPerformed(ActionEvent evt) {
		System.out.println("txtPassword.actionPerformed, event="+evt);
		btnLogin.doClick();
	}

	public class VotingTraversalPolicy extends FocusTraversalPolicy {

		@Override
		public Component getComponentAfter(Container aContainer, Component aComponent) {
			if(aComponent.equals(txtEmpNtnetId)){ 
				return txtPassword;           
			}else if(aComponent.equals(txtPassword)){ 
				return btnLogin;           
			}else{
				return txtEmpNtnetId;
			}
		}

		@Override
		public Component getComponentBefore(Container aContainer, Component aComponent) {
			if(aComponent.equals(txtEmpNtnetId)){ 
				return btnLogin;           
			}else if(aComponent.equals(txtPassword)){ 
				return txtEmpNtnetId;           
			}else{
				return txtPassword;
			}
		}

		@Override
		public Component getDefaultComponent(Container aContainer) {
			return txtEmpNtnetId;
		}

		@Override
		public Component getFirstComponent(Container aContainer) {
			return txtEmpNtnetId;
		}

		@Override
		public Component getLastComponent(Container aContainer) {
			return btnLogin;
		}
		
		
	}
	
}
