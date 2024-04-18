import java.lang.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.*;
import java.text.DecimalFormat;
import java.util.Timer;
import java.util.Random;
//ALl PASSENGER INFORMATION /.........................................................................................//

class passengerInfo{

    //NUMBER OF PASSENGERS
    private static int maxPassenger=48;
    public static void setmaxPassenger(int PassengerNo){
        maxPassenger=PassengerNo;
    }
    public static int getMaxPassenger(){
        return maxPassenger;
    }

    // CURRENT PASSENGER NUMBER
    private static int PassengerNumber;

    public static void setPassengerNumber(int PassengerNumber1){
        PassengerNumber=PassengerNumber1;
    }
    public static int getPassengerNumber(){
        return PassengerNumber;
    }

    // PASSENGER INFORMATIONS
    private static final String[] passengerFirstName = new String[maxPassenger];
    private static final String[] passengerLastName = new String[maxPassenger];
    private static final int[] passengerAge = new int[maxPassenger];
    private static final boolean[] passengerSex = new boolean[maxPassenger];
    //male=1 female=0

    public static void setPassengerFirstName(String FirstName){
        passengerFirstName[PassengerNumber]=FirstName;
    }
    public static String getPassengerFirstName(){
        return passengerFirstName[PassengerNumber];
    }

    public static void setPassengerLastName(String LastName){
        passengerLastName[PassengerNumber]=LastName;
    }
    public static String getPassengerLastName(){
        return passengerLastName[PassengerNumber];
    }

    public static void setPassengerAge(int Age){
        passengerAge[PassengerNumber]=Age;
    }
    public static int getPassengerAge(){
        return passengerAge[PassengerNumber];
    }

    public static void setPassengerSex(boolean Sex){
        passengerSex[PassengerNumber]=Sex;
    }
    public static boolean getPassengerSex(){
        return passengerSex[PassengerNumber];
    }

    // PRICES
    private static final double[] passengerTotalPrice = new double[maxPassenger];

    public static void setPassengerTotalPrice(double TotalPrice){
        passengerTotalPrice[PassengerNumber]=TotalPrice;
    }
    public static double getPassengerTotalPrice(){
        return passengerTotalPrice[PassengerNumber];
    }

    // BAGGAGE AND INSURANCE
    private static final boolean[] passengerInsurance = new boolean[maxPassenger];

    public static void setPassengerInsurance(boolean Insurance){
        passengerInsurance[PassengerNumber]=Insurance;
    }
    public static boolean getPassengerInsurance(){
        return passengerInsurance[PassengerNumber];
    }
}

//FLIGHT INFORMATION //..............................................................................................//

class flightInfo{

    /*
    Plane Class
    - Private = 1
    - Business = 2
    - Regular = 3

    Location
    - Local = 1
    - International = 2

    Destination
    -Manila to Batanes = A
    -Batanes to Manila = B
    -Manila to Palawan = C
    -Palawan to Manila = D
    -Manila to South Korea = E
    -South Korea to Manila = F
    -Manila to Japan = G
    -Japan to Manila = H
    -Manila to Vietnam = I
    -Vietnam to Manila = J

    TripType
    - One-Way Trip = 0
    - Round Trip = 1
    */

    private int planeClass=0;
    private int location=0;
    private int tripType;
    private double insurance;
    private double prices;
    private double pricesTax;

    public void setInsurance(double Insurance){
        insurance=Insurance;
    }
    public double getInsurance(){
        return insurance;
    }

    public void setPricesTax(double PriceTax){
        pricesTax=PriceTax;
    }
    public double getPricesTaxPrices(){
        return pricesTax;
    }

    public void setPrices(double Price){
        prices=Price;
    }
    public double getPrices(){
       return prices;
    }

    public void setPlaneClass(int planeClass1){
       planeClass=planeClass1;
    }
    public int getPlaneClass(){
        return planeClass;
    }

    public void setLocation(int Location1){
        location=Location1;
    }
    public int getLocation(){
        return location;
    }

    public void setTripType(int TripType1){
        tripType=TripType1;
    }
    public int getTripType(){
        return tripType;
    }

}

//MAIN CLASS //......................................................................................................//

public class PROJECT_FINAL extends JFrame{

    public static int counterUni;
    public static double finalTotalPrice=0;

    public static DecimalFormat commaFormat = new DecimalFormat("#.##");

    public final flightInfo flightInformation = new flightInfo();
    public final passengerInfo passengerInformation= new passengerInfo();

    public final StartPageSWED StartPage = new StartPageSWED();
    public final FlightInfo Panel1 = new FlightInfo();
    public final PassengerInfo Panel2= new PassengerInfo();
    public final FlightReceiptSummary Panel3= new FlightReceiptSummary();

    public static ImageIcon mainPage = new ImageIcon("MAINPAGE.png");
    public static ImageIcon backgroundImg = new ImageIcon("BACKGROUND.jpg");
    public static ImageIcon manilaImg = new ImageIcon("Manila-Final-Copy.png");
    public static ImageIcon batanesImg = new ImageIcon("Batanes-Final - Copy.png");
    public static ImageIcon palawanImg = new ImageIcon("Palawan-Final - Copy.png");
    public static ImageIcon southKoreaImg = new ImageIcon("SouthKorea-Final - Copy.png");
    public static ImageIcon japanImg = new ImageIcon("Japan-Final - Copy.png");
    public static ImageIcon vietnamImg = new ImageIcon("Vietnam-Final-Copy.png");
    public static ImageIcon warningImg = new ImageIcon("WARNING.png");

    public static ImageIcon manilaImgBackground = new ImageIcon("MANILA_BG.png");
    public static ImageIcon batanesImgBackground = new ImageIcon("BATANES_BG.png");
    public static ImageIcon palawanImgBackground = new ImageIcon("PALAWAN_BG.png");
    public static ImageIcon southKoreaImgBackground = new ImageIcon("SOUTH_KOREA_BG.png");
    public static ImageIcon japanImgBackground = new ImageIcon("JAPAN_BG.png");
    public static ImageIcon vietnamImgBackground = new ImageIcon("VIETNAM_BG.png");

    public static ImageIcon logoImg = new ImageIcon("astroboy1.png");
    public static ImageIcon logoExit = new ImageIcon("EXIT-HOVER.png");
    public static ImageIcon logoExitHover = new ImageIcon("EXIT-RED.png");

    // TABLE COMPONENTS
    public static JPanel panelTable = new JPanel();
    public static JTable table;
    public static JTableHeader header;
    public static JScrollPane pane;

    //ERROR MESSAGES
    public static Runnable runnable =
            (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.exclamation");

    // SIDE PANELS FOCUS
    JLabel sideLine1;
    JLabel sideLine2;
    JLabel sideLine3;

    // TIMER

    public static class PROJECTLOADING extends JFrame{

        PROJECTLOADING(){
            JFrame logo = new JFrame();
            logo.setUndecorated(true);
            logo.setVisible(true);
            logo.setBackground (new Color(0,0,0,0));

            ImageIcon image1 = new ImageIcon("LOGO.png");
            JLabel JLlogo = new JLabel(image1);
            JLlogo.setIcon(new ImageIcon(image1.getImage().getScaledInstance(1057-200, 897-200, Image.SCALE_SMOOTH)));
            JLlogo.setBounds(36,20,550,135);

            //JLabel label1 = new JLabel(image1);
            logo.add(JLlogo);
            logo.pack();
            logo.setLocationRelativeTo(null);

            JFrame second = new JFrame();
            second.setSize(500,200);
            logo.setLocationRelativeTo(null);

            counterUni=0;
            Timer timer = new Timer();
            TimerTask task = new TimerTask(){
                @Override
                public void run() {

                    if (counterUni != 3){
                        counterUni++;
                    }else{
                        timer.cancel();
                        logo.setVisible(false);

// CONSTRUCTOR CALLING

                        new PROJECT_FINAL();
                    }
                }
            };
            timer.schedule(task, 2000, 1000);
        }
    }

    public static void main(String[] args) {
        new PROJECTLOADING();
    }

    static class ButtonCustom extends JButton {
        private Color hoverBackgroundColor;
        private Color pressedBackgroundColor;

        public ButtonCustom() {
            this(null);
        }

        public ButtonCustom(String text) {
            super(text);
            super.setContentAreaFilled(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            if (getModel().isPressed()) {
                g.setColor(pressedBackgroundColor);
            } else if (getModel().isRollover()) {
                g.setColor(hoverBackgroundColor);
            } else {
                g.setColor(getBackground());
            }
            g.fillRect(0, 0, getWidth(), getHeight());
            super.paintComponent(g);
        }

        @Override
        public void setContentAreaFilled(boolean b) {
        }

        public void setHoverBackgroundColor(Color hoverBackgroundColor) {
            this.hoverBackgroundColor = hoverBackgroundColor;
        }

        public void setPressedBackgroundColor(Color pressedBackgroundColor) {
            this.pressedBackgroundColor = pressedBackgroundColor;
        }
    }

    public static class ErrorCreator extends JPanel{

        public static JLabel warningText;

        ErrorCreator(){

            ImageIcon warningIcon1 = warningImg;

            JLabel warningIcon = new JLabel();
            warningIcon.setIcon(new ImageIcon(warningIcon1.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH)));
            warningIcon.setBounds(0,0,15,15);

            warningText = new JLabel();
            warningText.setFont(new Font("Leelawadee", Font.BOLD,12));
            warningText.setForeground(new Color(194, 203, 208));
            warningText.setBounds(20,0,400,15);

            setFont(new Font("Leelawadee", Font.BOLD,12));
            setForeground(new Color(194, 203, 208));
            setBackground((new Color(38, 38, 38,255)));
            add(warningText);
            add(warningIcon);
            setLayout(null);
        }
    }


    public static class TextCreator extends JLabel{
        TextCreator(){
            setFont(new Font("Leelawadee", Font.BOLD,20));
            setForeground(new Color(194, 203, 208));
        }
    }

    public static class RadioButtonCreator extends JRadioButton{
        RadioButtonCreator(){
            setFont(new Font("Leelawadee", Font.PLAIN,16));
            setBackground(new Color(65, 70, 74,235));
            setForeground(new Color(194, 203, 208));
            setFocusable(false);

        }
    }

    //PANEL 1 //.....................................................................................................//

    public class FlightInfo extends JPanel implements ActionListener{

        // PASSENGER NUMBER VARIABLES
        JPanel passengerNoPanel;
        JPanel numPassengerCover;
        SpinnerModel numPassengerValue;
        SpinnerModel numPassengerValue1;
        SpinnerModel numPassengerValue2;
        JSpinner numPassenger;
        JSpinner numPassenger1;
        JSpinner numPassenger2;
        TextCreator label9;
        TextCreator label10;

        // DESTINATION VARIABLES
        public static JComboBox destinationFrom;
        public static JComboBox destinationTo;
        JPanel destiToCover;
        JPanel destiFromCover;

        // LOCATION VARIABLES
        ButtonGroup locationGroup;
        ButtonGroup planeClassGroup;
        ButtonGroup tripGroup;
        RadioButtonCreator internationalButton;
        RadioButtonCreator localButton;
        RadioButtonCreator privateButton;
        RadioButtonCreator businessButton;
        RadioButtonCreator regularButton;

        // BUTTON NEXT PANEL 1
        ButtonCustom btnNext;
        ButtonCustom btnBack;

        // PRICES
        JLabel travelFare;
        JLabel travelFarePeso;
        JLabel travelTax;
        JLabel travelTaxPeso;

        // TRIP TYPE
        RadioButtonCreator oneWayButton;
        RadioButtonCreator roundButton;

        // SHOW LOCATION PICTURE
        JLabel locationPicture;
        JLabel labelLocationText;

        // ERROR MESSAGES
        ErrorCreator error1;
        ErrorCreator error2;
        ErrorCreator error3;

        // COMBO BOXES
        String[] LocalDestination= {"Manila", "Batanes", "Palawan"};
        String[] LocalDestination3= {"Batanes", "Palawan"};
        String[] LocalDestination4= {"Palawan", "Batanes"};
        String[] LocalDestination7= {"Manila"};

        String[] InternationalDestination = {"Manila", "South Korea", "Japan", "Vietnam"};
        String[] InternationalDestination1 = {"South Korea", "Japan", "Vietnam"};
        String[] InternationalDestination2 = {"Japan", "South Korea", "Vietnam"};
        String[] InternationalDestination3= {"Vietnam", "South Korea", "Japan"};
        String[] InternationalDestination4= {"Manila"};

        // BORDERS
        public static Border Border_White = BorderFactory.createLineBorder(new Color(194, 203, 208) ,1);

        // FLIGHT INFORMATION CONSTRUCTOR
        FlightInfo(){

            btnBack = new ButtonCustom("Back");
            btnBack.setFont(new Font("Leelawadee", Font.BOLD,18));
            btnBack.setBackground(new Color(21, 22, 24));
            btnBack.setForeground(new Color(194, 203, 208));
            btnBack.setBounds(760, 660, 120, 40);
            btnBack.setHoverBackgroundColor(new Color(32, 34, 37));
            btnBack.setPressedBackgroundColor(new Color(4, 28, 51));
            btnBack.setBorder(Panel1.Border_White);
            btnBack.setFocusable(false);
            btnBack.addActionListener(this);

            // BUTTON NEXT
            btnNext = new ButtonCustom("Next");
            btnNext.setFont(new Font("Leelawadee", Font.BOLD,18));
            btnNext.setBackground(new Color(21, 22, 24));
            btnNext.setForeground(new Color(194, 203, 208));
            btnNext.setBounds(960, 660, 120, 40);
            btnNext.setHoverBackgroundColor(new Color(32, 34, 37));
            btnNext.setPressedBackgroundColor(new Color(4, 28, 51));
            btnNext.setBorder(Panel1.Border_White);
            btnNext.setFocusable(false);
            btnNext.addActionListener(this);

            //Sub Panel
            JLabel background = new JLabel();
            background.setIcon(backgroundImg);
            background.setBounds(250,30,1000,700);

        // Upper Design

            JLabel labelflight = new JLabel("FLIGHT INFORMATION", JLabel.LEFT);
            labelflight.setFont(new Font("Leelawadee", Font.BOLD,24));
            labelflight.setForeground(new Color(255, 214, 98));
            labelflight.setBounds(12,12,300,42);

            JPanel titleflight = new JPanel();
            titleflight.setBackground(new Color(1, 83, 157));
            titleflight.setBounds(0,0,450,60);

            JPanel titleline = new JPanel();
            titleline.setBackground(new Color(194, 203, 208));
            titleline.setBounds(0,60,450,2);

        // Plane Class

            final TextCreator label1= new TextCreator();
            label1.setText("Plane Class");
            label1.setBounds(12,75,300,42);

            privateButton = new RadioButtonCreator();
            privateButton.setText("Private");
            privateButton.setBounds(50,4,78,22);
            privateButton.addActionListener(this);

            businessButton = new RadioButtonCreator();
            businessButton.setText("Business");
            businessButton.setBounds(180,4,88,22);
            businessButton.addActionListener(this);

            regularButton = new RadioButtonCreator();
            regularButton.setText("Regular");
            regularButton.setBounds(320,4,88,22);
            regularButton.addActionListener(this);

            planeClassGroup=new ButtonGroup();
            planeClassGroup.add(businessButton);
            planeClassGroup.add(privateButton);
            planeClassGroup.add(regularButton);



            JPanel classPanel = new JPanel();
            classPanel.setBackground(new Color(65, 70, 74,255));
            classPanel.setBounds(0,120,450,30);
            classPanel.add(privateButton);
            classPanel.add(businessButton);
            classPanel.add(regularButton);
            classPanel.setLayout(null);

            error1 = new ErrorCreator();
            ErrorCreator.warningText.setText("Please select a Plane Class.");
            error1.setBounds(180,90,200,15);
            error1.setVisible(false);

        // Location

            final TextCreator label2= new TextCreator();
            label2.setText("Location");
            label2.setBounds(12,165,300,42);

            localButton = new RadioButtonCreator();
            localButton.setText("Local");
            localButton.setBounds(100,4,62,22);
            localButton.addActionListener(this);

            internationalButton = new RadioButtonCreator();
            internationalButton.setText("International");
            internationalButton.setBounds(240,4,120,22);
            internationalButton.addActionListener(this);

            locationGroup=new ButtonGroup();
            locationGroup.add(localButton);
            locationGroup.add(internationalButton);

            JPanel locationPanel = new JPanel();
            locationPanel.setBackground(new Color(65, 70, 74,255));
            locationPanel.setBounds(0,210,450,30);
            locationPanel.add(localButton);
            locationPanel.add(internationalButton);
            locationPanel.setLayout(null);

            error2 = new ErrorCreator();
            ErrorCreator.warningText.setText("Please select Location.");
            error2.setBounds(180,180,200,15);
            error2.setVisible(false);

        // Destination

            final TextCreator label3= new TextCreator();
            label3.setText("Destination");
            label3.setBounds(12,250,300,42);

            final TextCreator label4= new TextCreator();
            label4.setText("From:");
            label4.setFont(new Font("Leelawadee", NORMAL,16));
            label4.setBounds(15,2,300,35);

            final TextCreator label5= new TextCreator();
            label5.setText("To:");
            label5.setFont(new Font("Leelawadee", NORMAL,16));
            label5.setBounds(205,2,300,35);

            destiFromCover = new JPanel();
            destiFromCover.setBackground(new Color(21, 22, 24));
            destiFromCover.setBounds(65,6,120,29);
            destiFromCover.setBorder(Border_White);

            destiToCover = new JPanel();
            destiToCover.setBackground(new Color(21, 22, 24));
            destiToCover.setBounds(237,6,120,29);
            destiToCover.setBorder(Border_White);

            destinationFrom = new JComboBox(LocalDestination);
            destinationFrom.setBackground(new Color(21, 22, 24));
            destinationFrom.setForeground(new Color(194, 203, 208));
            destinationFrom.setBounds(65,6,120,29);
            destinationFrom.addActionListener(this);
            destinationFrom.setVisible(false);
            destinationFrom.setFocusable(false);

            destinationTo = new JComboBox(LocalDestination);
            destinationTo.removeItem("Manila");
            destinationTo.setBackground(new Color(21, 22, 24));
            destinationTo.setForeground(new Color(194, 203, 208));
            destinationTo.setBounds(237,6,120,29);
            destinationTo.addActionListener(this);
            destinationTo.setVisible(false);
            destinationTo.setFocusable(false);

            //.......................................................................................................//

            JPanel destinationPanel = new JPanel();
            destinationPanel.setBackground(new Color(65, 70, 74,255));
            destinationPanel.setBounds(0,295,450,40);
            destinationPanel.add(destinationTo);
            destinationPanel.add(destinationFrom);
            destinationPanel.add(destiToCover);
            destinationPanel.add(destiFromCover);
            destinationPanel.add(label4);
            destinationPanel.add(label5);
            destinationPanel.setLayout(null);

            // FINAL FLIGHT PANEL ..................................................................................//

            JPanel flightInfo = new JPanel();
            flightInfo.setBackground(new Color(38, 38, 38,255));
            flightInfo.setBounds(280,60,450,360);
            //flightInfo.add(prices);
         /*
            flightInfo.add(label9);
            flightInfo.add(numPassengerCover);
            flightInfo.add(numPassenger);
            flightInfo.add(label8);
         */
            flightInfo.add(error2);
            flightInfo.add(error1);
            flightInfo.add(destinationPanel);
            flightInfo.add(label3);
            flightInfo.add(locationPanel);
            flightInfo.add(label2);
            flightInfo.add(classPanel);
            flightInfo.add(label1);
            flightInfo.add(labelflight);
            flightInfo.add(titleflight);
            flightInfo.add(titleline);
            flightInfo.setLayout(null);

        //PASSENGER NO PANEL .......................................................................................//

            JLabel labelpassengerNo = new JLabel("FLIGHT DATE & PASSENGER QUANTITY", JLabel.LEFT);
            labelpassengerNo.setFont(new Font("Leelawadee", Font.BOLD,20));
            labelpassengerNo.setForeground(new Color(255, 214, 98));
            labelpassengerNo.setBounds(12,12,600,42);

            JPanel titlepassengerNo = new JPanel();
            titlepassengerNo.setBackground(new Color(1, 83, 157));
            titlepassengerNo.setBounds(0,0,450,60);

            JPanel titleline1 = new JPanel();
            titleline1.setBackground(new Color(194, 203, 208));
            titleline1.setBounds(0,60,450,2);

            // NUMBER OF PASSENGERS ................................................................................//

            final TextCreator label8= new TextCreator();
            label8.setText("No. of Passengers: ");
            label8.setBounds(12,70,300,42);

            label9= new TextCreator();
            label10= new TextCreator();

            label9.setFont(new Font("Leelawadee", Font.BOLD,12));
            label9.setText("Maximum");
            label9.setBackground(new Color(21, 22, 24));
            label9.setBounds(12,0,100,15);

            label10.setFont(new Font("Leelawadee", Font.BOLD,12));
            label10.setBackground(new Color(21, 22, 24));
            label10.setForeground(new Color(255, 214, 98));
            label10.setBounds(75,0,100,15);

            JPanel maximumLine = new JPanel();
            maximumLine.setBackground(new Color(194, 203, 208));
            maximumLine.setBounds(84,118,20,1);

            JPanel maximumPerson = new JPanel();
            maximumPerson.setBackground(new Color(38, 38, 38,0));
            maximumPerson.setBounds(12,103,100,50);
            maximumPerson.add(label9);
            maximumPerson.add(label10);
            maximumPerson.setLayout(null);

            numPassengerCover = new JPanel();
            numPassengerCover.setBackground(new Color(21, 22, 24));
            numPassengerCover.setBounds(215,77,100,30);
            numPassengerCover.setBorder(Border_White);

            numPassengerValue = new SpinnerNumberModel(1, 1, 14, 1);
            numPassengerValue1 = new SpinnerNumberModel(1, 1, 23, 1);
            numPassengerValue2 = new SpinnerNumberModel(1, 1, 48, 1);

            numPassenger = new JSpinner(numPassengerValue);
            numPassenger.setBounds(215,77,100,30);
            numPassenger.setEditor(new JSpinner.DefaultEditor(numPassenger));
            numPassenger.getEditor().getComponent(0).setBackground(new Color(21, 22, 24));
            numPassenger.getEditor().getComponent(0).setForeground(new Color(194, 203, 208));
            numPassenger.getEditor().getComponent(0).setFont(new Font("Leelawadee", Font.BOLD,14));
            numPassenger.setVisible(false);

            numPassenger1 = new JSpinner(numPassengerValue1);
            numPassenger1.setBounds(215,77,100,30);
            numPassenger1.setEditor(new JSpinner.DefaultEditor(numPassenger1));
            numPassenger1.getEditor().getComponent(0).setBackground(new Color(21, 22, 24));
            numPassenger1.getEditor().getComponent(0).setForeground(new Color(194, 203, 208));
            numPassenger1.getEditor().getComponent(0).setFont(new Font("Leelawadee", Font.BOLD,14));
            numPassenger1.setVisible(false);

            numPassenger2 = new JSpinner(numPassengerValue2);
            numPassenger2.setBounds(215,77,100,30);
            numPassenger2.setEditor(new JSpinner.DefaultEditor(numPassenger2));
            numPassenger2.getEditor().getComponent(0).setBackground(new Color(21, 22, 24));
            numPassenger2.getEditor().getComponent(0).setForeground(new Color(194, 203, 208));
            numPassenger2.getEditor().getComponent(0).setFont(new Font("Leelawadee", Font.BOLD,14));
            numPassenger2.setVisible(false);

            //  ONE-WAY OR ROUND TRIP ...............................................................................//

            oneWayButton = new RadioButtonCreator();
            oneWayButton.setText("One-Way Trip");
            oneWayButton.setBounds(80,4,150,22);
            oneWayButton.addActionListener(this);

            roundButton = new RadioButtonCreator();
            roundButton.setText("Round Trip");
            roundButton.setBounds(240,4,120,22);
            roundButton.addActionListener(this);

            tripGroup=new ButtonGroup();
            tripGroup.add(oneWayButton);
            tripGroup.add(roundButton);

            JPanel tripPanel = new JPanel();
            tripPanel.setBackground(new Color(65, 70, 74,255));
            tripPanel.setBounds(0,138,450,30);
            tripPanel.add(oneWayButton);
            tripPanel.add(roundButton);
            tripPanel.setLayout(null);

            error3 = new ErrorCreator();
            ErrorCreator.warningText.setText("Please select Trip Type.");
            error3.setBounds(140,173,200,15);
            error3.setVisible(false);

            passengerNoPanel = new JPanel();
            passengerNoPanel.setBackground((new Color(38, 38, 38,255)));
            passengerNoPanel.setBounds(280,445,450,195);
            passengerNoPanel.add(error3);
            passengerNoPanel.add(tripPanel);
            passengerNoPanel.add(maximumLine);
            passengerNoPanel.add(maximumPerson);
            passengerNoPanel.add(label8);
            passengerNoPanel.add(numPassengerCover);
            passengerNoPanel.add(numPassenger1);
            passengerNoPanel.add(numPassenger);
            passengerNoPanel.add(numPassenger2);
            passengerNoPanel.add(labelpassengerNo);
            passengerNoPanel.add(titlepassengerNo);
            passengerNoPanel.add(titleline1);
            passengerNoPanel.setLayout(null);

            // SHOW LOCATION PICTURE PANEL

            labelLocationText = new JLabel("NO DESTINATION SELECTED.", JLabel.LEFT);
            labelLocationText.setFont(new Font("Leelawadee", Font.BOLD,20));
            labelLocationText.setForeground(new Color(255, 214, 98));
            labelLocationText.setBounds(12,370,600,42);

            JPanel titleLocation = new JPanel();
            titleLocation.setBackground(new Color(1, 83, 157));
            titleLocation.setBounds(0,360,320,60);

            JPanel titleline2 = new JPanel();
            titleline2.setBackground(new Color(194, 203, 208));
            titleline2.setBounds(0,360,320,2);

            locationPicture = new JLabel();
            locationPicture.setBounds(2,2,316,358);

            JPanel showPicturePanel = new JPanel();
            showPicturePanel.setBackground((new Color(38, 38, 38,255)));
            showPicturePanel.setBounds(760,60,320,420);
            showPicturePanel.add(labelLocationText);
            showPicturePanel.add(locationPicture);
            showPicturePanel.add(titleline2);
            showPicturePanel.add(titleLocation);
            showPicturePanel.setLayout(null);

            // SOME INFORMATION AND STUFFS

            JPanel pricesBox1 = new JPanel();
            pricesBox1.setBackground(new Color(1, 83, 157));
            pricesBox1.setBounds(0,0,320,42);

            JPanel titleline3 = new JPanel();
            titleline3.setBackground(new Color(194, 203, 208));
            titleline3.setBounds(0,42,320,2);

            JLabel priceTitle = new JLabel("PRICES AND FEE", JLabel.LEFT);
            priceTitle.setFont(new Font("Leelawadee", Font.BOLD,18));
            priceTitle.setForeground(new Color(255, 214, 98));
            priceTitle.setBounds(10,2,320,42);

            JLabel travelFareTitle = new JLabel("Travel Fare: ", JLabel.LEFT);
            travelFareTitle.setFont(new Font("Leelawadee", NORMAL,15));
            travelFareTitle.setForeground(new Color(194, 203, 208));
            travelFareTitle.setBounds(15,45,320,42);

            travelFarePeso = new JLabel("₱");
            travelFarePeso.setFont(new Font("Arial", NORMAL,14));
            travelFarePeso.setForeground(new Color(255, 214, 98));
            travelFarePeso.setBounds(105,57,100,20);
            travelFarePeso.setVisible(false);

            travelFare = new JLabel();
            travelFare.setFont(new Font("Leelawadee", NORMAL,14));
            travelFare.setForeground(new Color(255, 214, 98));
            travelFare.setBounds(118,57,100,20);

            JPanel travelFareLine = new JPanel();
            travelFareLine.setBackground(new Color(194, 203, 208));
            travelFareLine.setBounds(95,77,100,1);

            JLabel travelTaxTitle = new JLabel("Travel Tax: ", JLabel.LEFT);
            travelTaxTitle.setFont(new Font("Leelawadee", NORMAL,15));
            travelTaxTitle.setForeground(new Color(194, 203, 208));
            travelTaxTitle.setBounds(15,75,320,42);

            travelTaxPeso = new JLabel("₱");
            travelTaxPeso.setFont(new Font("Arial", NORMAL,14));
            travelTaxPeso.setForeground(new Color(255, 214, 98));
            travelTaxPeso.setBounds(105,86,100,20);
            travelTaxPeso.setVisible(false);

            travelTax = new JLabel();
            travelTax.setFont(new Font("Leelawadee", NORMAL,14));
            travelTax.setForeground(new Color(255, 214, 98));
            travelTax.setBounds(118,86,100,20);

            JPanel travelTaxLine = new JPanel();
            travelTaxLine.setBackground(new Color(194, 203, 208));
            travelTaxLine.setBounds(95,107,100,1);

            JPanel showOtherInfo = new JPanel();
            showOtherInfo.setBackground((new Color(38, 38, 38,255)));
            showOtherInfo.setBounds(760,505,320,135);
            showOtherInfo.add(travelTaxPeso);
            showOtherInfo.add(travelTax);
            showOtherInfo.add(travelTaxLine);
            showOtherInfo.add(travelTaxTitle);
            showOtherInfo.add(travelFarePeso);
            showOtherInfo.add(travelFare);
            showOtherInfo.add(travelFareLine);
            showOtherInfo.add(travelFareTitle);
            showOtherInfo.add(priceTitle);
            showOtherInfo.add(titleline3);
            showOtherInfo.add(pricesBox1);
            showOtherInfo.setLayout(null);

            //Main Panel
            setBackground(new Color(235, 236, 237));
            setBounds(0,0,1120,720);
            add(showOtherInfo);
            add(showPicturePanel);
            add(passengerNoPanel);
            add(flightInfo);
            add(btnBack);
            add(btnNext);
            add(background);
            setLayout(null);
            setVisible(false);

        }

        //ACTION LISTENERS  .........................................................................................//

        public void actionPerformed(ActionEvent e) {

            if(e.getSource()==btnBack){

                // CLEAR FLIGHT INFORMATION .........................................................................//

                // NUM PASSENGER VALUES
                numPassengerValue.setValue(1);
                numPassengerValue1.setValue(1);
                numPassengerValue2.setValue(1);

                // VALUES
                flightInformation.setPlaneClass(0);
                flightInformation.setLocation(0);
                flightInformation.setTripType(0);

                // MAP IMG
                locationPicture.setVisible(false);
                labelLocationText.setText("NO DESTINATION SELECTED.");
                labelLocationText.setBounds(12,370,600,42);

                // RADIO BUTTON
                planeClassGroup.clearSelection();
                locationGroup.clearSelection();
                tripGroup.clearSelection();

                // MAX PASSENGER SHOW
                label10.setText("");

                // PASSENGER UP DOWN
                numPassenger.setVisible(false);
                numPassenger1.setVisible(false);
                numPassenger2.setVisible(false);
                numPassengerCover.setVisible(true);

                // ERROR MESSAGES
                error1.setVisible(false);
                error2.setVisible(false);
                error3.setVisible(false);

                // PRICES
                travelFare.setVisible(false);
                travelFarePeso.setVisible(false);
                travelTax.setVisible(false);
                travelTaxPeso.setVisible(false);

                // SHOW PANELS
                StartPage.setVisible(true);
                Panel1.setVisible(false);
                Panel2.setVisible(false);
                Panel3.setVisible(false);

                // SIDE PANELS
                sideLine1.setVisible(false);
                sideLine2.setVisible(false);
                sideLine3.setVisible(false);

            }

            commaFormat.setGroupingUsed(true);
            commaFormat.setGroupingSize(3);

            // PLANE CLASS ..........................................................................................//

            if(e.getSource()==privateButton || e.getSource()==businessButton || e.getSource()==regularButton) {

                numPassengerCover.setVisible(false);

                if (e.getSource() == privateButton) {
                    if (privateButton.isSelected()) {
                        label10.setText("14");
                        flightInformation.setInsurance(4500);
                        flightInformation.setPlaneClass(1);
                        flightInformation.setPricesTax(4260);
                        passengerInformation.setmaxPassenger(14);
                        numPassenger.setVisible(true);
                        numPassenger1.setVisible(false);
                        numPassenger1.setValue(1);
                        numPassenger2.setVisible(false);
                        numPassenger2.setValue(1);
                    }
                } else if (e.getSource() == businessButton) {
                    if (businessButton.isSelected()) {
                        label10.setText("23");
                        flightInformation.setInsurance(6500);
                        flightInformation.setPlaneClass(2);
                        flightInformation.setPricesTax(5700);
                        passengerInformation.setmaxPassenger(23);
                        numPassenger.setVisible(false);
                        numPassenger.setValue(1);
                        numPassenger1.setVisible(true);
                        numPassenger2.setVisible(false);
                        numPassenger2.setValue(1);
                    }
                } else if (e.getSource() == regularButton) {
                    if (regularButton.isSelected()) {
                        label10.setText("48");
                        flightInformation.setInsurance(950);
                        flightInformation.setPricesTax(2500);
                        flightInformation.setPlaneClass(3);
                        passengerInformation.setmaxPassenger(23);
                        numPassenger.setVisible(false);
                        numPassenger.setValue(1);
                        numPassenger1.setVisible(false);
                        numPassenger1.setValue(1);
                        numPassenger2.setVisible(true);
                    }
                }

                travelTaxPeso.setVisible(true);
                travelTax.setVisible(true);
                travelTax.setText(commaFormat.format(flightInformation.getPricesTaxPrices())+".00");

            }

            // LOCATION .............................................................................................//

            if(e.getSource()==localButton){
                if(localButton.isSelected()){
                    flightInformation.setLocation(1);
                    destinationTo.setModel(new DefaultComboBoxModel(LocalDestination3));
                    destinationFrom.setModel(new DefaultComboBoxModel(LocalDestination));
                }
            }else if (e.getSource()==internationalButton){
                if(internationalButton.isSelected()){
                    flightInformation.setLocation(2);
                    destinationTo.setModel(new DefaultComboBoxModel(InternationalDestination1));
                    destinationFrom.setModel(new DefaultComboBoxModel(InternationalDestination));
                }
            }
                if(flightInformation.getLocation() == 0){
                    destinationFrom.setVisible(false);
                    destinationTo.setVisible(false);
                }

                // LOCAL CONDITIONS ................................................................................//
                else if (flightInformation.getLocation() == 1) {

                    if(flightInformation.getPlaneClass()==1){
                        flightInformation.setPrices(8000);
                    }else if(flightInformation.getPlaneClass()==2){
                        flightInformation.setPrices(12500);
                    }else if(flightInformation.getPlaneClass()==3){
                        flightInformation.setPrices(3500);
                    }

                    locationPicture.setVisible(true);
                    destinationFrom.setVisible(true);
                    destinationTo.setVisible(true);

                    if(e.getSource()==destinationFrom) {
                        if (destinationFrom.getSelectedItem().equals("Manila")) {
                            if(destinationTo.getSelectedItem().equals("Batanes")||destinationTo.getSelectedItem().equals("Manila")){
                                destinationTo.setModel(new DefaultComboBoxModel(LocalDestination3));
                            }else if(destinationTo.getSelectedItem().equals("Palawan")){
                                destinationTo.setModel(new DefaultComboBoxModel(LocalDestination4));
                            }
                        } else if (destinationFrom.getSelectedItem().equals("Batanes") || destinationFrom.getSelectedItem().equals("Palawan")) {
                            destinationTo.setModel(new DefaultComboBoxModel(LocalDestination7));
                        }
                    }

                    if (e.getSource() == destinationTo) {
                        if (destinationTo.getSelectedItem().equals("Manila")) {
                            if(destinationFrom.getSelectedItem().equals("Batanes")||destinationFrom.getSelectedItem().equals("Palawan")){
                                destinationTo.setModel(new DefaultComboBoxModel(LocalDestination7));
                            }
                        }
                    }

                // INTERNATIONAL CONDITIONS .........................................................................//
                }else if (flightInformation.getLocation() == 2){

                    if(flightInformation.getPlaneClass()==1){
                        flightInformation.setPrices(27450);
                    }else if(flightInformation.getPlaneClass()==2){
                        flightInformation.setPrices(37390);
                    }else if(flightInformation.getPlaneClass()==3){
                        flightInformation.setPrices(12055);
                    }

                    locationPicture.setVisible(true);
                    destinationFrom.setVisible(true);
                    destinationTo.setVisible(true);

                    if(e.getSource()==destinationFrom) {
                        if (destinationFrom.getSelectedItem().equals("Manila")) {
                            if(destinationTo.getSelectedItem().equals("South Korea")||destinationTo.getSelectedItem().equals("Manila")){
                                destinationTo.setModel(new DefaultComboBoxModel(InternationalDestination1));
                            }else if(destinationTo.getSelectedItem().equals("Japan")){
                                destinationTo.setModel(new DefaultComboBoxModel(InternationalDestination2));
                            }else if(destinationTo.getSelectedItem().equals("Vietnam")){
                                destinationTo.setModel(new DefaultComboBoxModel(InternationalDestination3));
                            }
                        } else if (destinationFrom.getSelectedItem().equals("South Korea") || destinationFrom.getSelectedItem().equals("Japan")|| destinationFrom.getSelectedItem().equals("Vietnam")) {
                            destinationTo.setModel(new DefaultComboBoxModel(InternationalDestination4));
                        }
                    }
                    if (e.getSource() == destinationTo) {
                        if (destinationTo.getSelectedItem().equals("Manila")) {
                            if(destinationFrom.getSelectedItem().equals("South Korea")||destinationFrom.getSelectedItem().equals("Vietnam")||destinationFrom.getSelectedItem().equals("Japan")){
                                destinationTo.setModel(new DefaultComboBoxModel(InternationalDestination4));
                            }
                        }
                    }
                }

                // PRICES ...........................................................................................//

                   if(destinationFrom.getSelectedItem().equals("Manila") && destinationTo.getSelectedItem().equals("Batanes")){
                            if(flightInformation.getPlaneClass()==1){
                                flightInformation.setPrices(8000);
                            }else if(flightInformation.getPlaneClass()==2){
                                flightInformation.setPrices(12500);
                            }else if(flightInformation.getPlaneClass()==3){
                                flightInformation.setPrices(3500);
                            }
                   }else if(destinationFrom.getSelectedItem().equals("Batanes") && destinationTo.getSelectedItem().equals("Manila")){
                           if(flightInformation.getPlaneClass()==1){
                             flightInformation.setPrices(9800);
                          }else if(flightInformation.getPlaneClass()==2){
                               flightInformation.setPrices(12950);
                          }else if(flightInformation.getPlaneClass()==3){
                               flightInformation.setPrices(3900);
                           }
                   }else if(destinationFrom.getSelectedItem().equals("Manila") && destinationTo.getSelectedItem().equals("Palawan")){
                         if(flightInformation.getPlaneClass()==1){
                             flightInformation.setPrices(9100);
                           }else if(flightInformation.getPlaneClass()==2){
                              flightInformation.setPrices(10500);
                          }else if(flightInformation.getPlaneClass()==3){
                             flightInformation.setPrices(3200);
                         }
                   }else if(destinationFrom.getSelectedItem().equals("Palawan") && destinationTo.getSelectedItem().equals("Manila")){
                        if(flightInformation.getPlaneClass()==1){
                           flightInformation.setPrices(9850);
                         }else if(flightInformation.getPlaneClass()==2){
                           flightInformation.setPrices(10975);
                          }else if(flightInformation.getPlaneClass()==3){
                            flightInformation.setPrices(3575);
                        }
                   }else if(destinationFrom.getSelectedItem().equals("Manila") && destinationTo.getSelectedItem().equals("South Korea")){
                       if(flightInformation.getPlaneClass()==1){
                           flightInformation.setPrices(27450);
                       }else if(flightInformation.getPlaneClass()==2){
                           flightInformation.setPrices(37390);
                       }else if(flightInformation.getPlaneClass()==3){
                           flightInformation.setPrices(12055);
                       }
                   }else if(destinationFrom.getSelectedItem().equals("South Korea") && destinationTo.getSelectedItem().equals("Manila")){
                       if(flightInformation.getPlaneClass()==1){
                           flightInformation.setPrices(30890);
                       }else if(flightInformation.getPlaneClass()==2){
                           flightInformation.setPrices(39650);
                       }else if(flightInformation.getPlaneClass()==3){
                           flightInformation.setPrices(13100);
                       }
                   }else if(destinationFrom.getSelectedItem().equals("Manila") && destinationTo.getSelectedItem().equals("Japan")){
                       if(flightInformation.getPlaneClass()==1){
                           flightInformation.setPrices(40450);
                       }else if(flightInformation.getPlaneClass()==2){
                           flightInformation.setPrices(45355);
                       }else if(flightInformation.getPlaneClass()==3){
                           flightInformation.setPrices(27800);
                       }
                   }else if(destinationFrom.getSelectedItem().equals("Japan") && destinationTo.getSelectedItem().equals("Manila")){
                       if(flightInformation.getPlaneClass()==1){
                           flightInformation.setPrices(43855);
                       }else if(flightInformation.getPlaneClass()==2){
                           flightInformation.setPrices(49780);
                       }else if(flightInformation.getPlaneClass()==3){
                           flightInformation.setPrices(29400);
                       }
                   }else if(destinationFrom.getSelectedItem().equals("Manila") && destinationTo.getSelectedItem().equals("Vietnam")){
                       if(flightInformation.getPlaneClass()==1){
                           flightInformation.setPrices(8505);
                       }else if(flightInformation.getPlaneClass()==2){
                           flightInformation.setPrices(12345);
                       }else if(flightInformation.getPlaneClass()==3){
                           flightInformation.setPrices(3200);
                       }
                   }else if(destinationFrom.getSelectedItem().equals("Vietnam") && destinationTo.getSelectedItem().equals("Manila")){
                       if(flightInformation.getPlaneClass()==1){
                           flightInformation.setPrices(14300);
                       }else if(flightInformation.getPlaneClass()==2){
                           flightInformation.setPrices(16320);
                       }else if(flightInformation.getPlaneClass()==3){
                           flightInformation.setPrices(4600);
                       }
                   }

                // DISPLAY MAP LOCATION .............................................................................//
            if(e.getSource()!=privateButton && e.getSource()!=businessButton && e.getSource()!=regularButton && e.getSource()!=btnNext && e.getSource()!=btnBack ) {
                if (destinationTo.getSelectedItem().equals("Batanes")) {
                    locationPicture.setIcon(batanesImg);
                    labelLocationText.setText("BATANES");
                    labelLocationText.setBounds(115, 370, 600, 42);
                } else if (destinationTo.getSelectedItem().equals("Palawan")) {
                    locationPicture.setIcon(palawanImg);
                    labelLocationText.setText("PALAWAN");
                    labelLocationText.setBounds(110, 370, 600, 42);
                } else if (destinationTo.getSelectedItem().equals("Manila")) {
                    locationPicture.setIcon(manilaImg);
                    labelLocationText.setText("MANILA");
                    labelLocationText.setBounds(120, 370, 600, 42);
                } else if (destinationTo.getSelectedItem().equals("Japan")) {
                    locationPicture.setIcon(japanImg);
                    labelLocationText.setText("JAPAN");
                    labelLocationText.setBounds(130, 370, 600, 42);
                } else if (destinationTo.getSelectedItem().equals("South Korea")) {
                    locationPicture.setIcon(southKoreaImg);
                    labelLocationText.setText("SOUTH KOREA");
                    labelLocationText.setBounds(90, 370, 600, 42);
                } else if (destinationTo.getSelectedItem().equals("Vietnam")) {
                    locationPicture.setIcon(vietnamImg);
                    labelLocationText.setText("VIETNAM");
                    labelLocationText.setBounds(115, 370, 600, 42);
                }
            }

                if(flightInformation.getPlaneClass()!=0 && flightInformation.getLocation()!=0) {
                    travelFarePeso.setVisible(true);
                    travelFare.setVisible(true);
                    travelFare.setText(commaFormat.format(flightInformation.getPrices())+".00");
                }

                // TRIP TYPE ........................................................................................//

                if(e.getSource()==oneWayButton || e.getSource()==roundButton) {

                    if(e.getSource()==oneWayButton){
                        flightInformation.setTripType(1);
                    }else if(e.getSource()==roundButton){
                        flightInformation.setTripType(2);
                    }

                }

            //  BUTTONS .............................................................................................//

            if(e.getSource()==btnNext){

                int maxPassenger=0;

                if(flightInformation.getPrices()!=0 && flightInformation.getPricesTaxPrices()!=0 && flightInformation.getTripType()!=0 && flightInformation.getPlaneClass()!=0&& flightInformation.getLocation()!=0 ) {

                    if(flightInformation.getPlaneClass()==1){
                        maxPassenger = (Integer) numPassengerValue.getValue();
                    }else if(flightInformation.getPlaneClass()==2){
                        maxPassenger = (Integer) numPassengerValue1.getValue();
                    }else if(flightInformation.getPlaneClass()==3){
                        maxPassenger = (Integer) numPassengerValue2.getValue();
                    }

                    // CHANGE MAX PASSENGER TO MAX PASSENGER SELECTED
                    passengerInformation.setmaxPassenger(maxPassenger);

                    // CHANGE BACKGROUNDSS FOR GUEST INFORMATION
                    if(destinationTo.getSelectedItem().equals("Manila")){
                        PassengerInfo.background1.setIcon(manilaImgBackground);
                        FlightReceiptSummary.background2.setIcon(manilaImgBackground);
                    }else if(destinationTo.getSelectedItem().equals("Batanes")){
                        PassengerInfo.background1.setIcon(batanesImgBackground);
                        FlightReceiptSummary.background2.setIcon(batanesImgBackground);
                    }else if(destinationTo.getSelectedItem().equals("Palawan")){
                        PassengerInfo.background1.setIcon(palawanImgBackground);
                        FlightReceiptSummary.background2.setIcon(palawanImgBackground);
                    }else if(destinationTo.getSelectedItem().equals("South Korea")){
                        PassengerInfo.background1.setIcon(southKoreaImgBackground);
                        FlightReceiptSummary.background2.setIcon(southKoreaImgBackground);
                    }else if(destinationTo.getSelectedItem().equals("Japan")){
                        PassengerInfo.background1.setIcon(japanImgBackground);
                        FlightReceiptSummary.background2.setIcon(japanImgBackground);
                    }else if(destinationTo.getSelectedItem().equals("Vietnam")){
                        PassengerInfo.background1.setIcon(vietnamImgBackground);
                        FlightReceiptSummary.background2.setIcon(vietnamImgBackground);
                    }
                    PassengerInfo.background1.setBounds(250,25,1000,700);

                    // CHANGE CLIENT SUMMARY
                    PassengerInfo.travelDepartureFlightText.setText(FlightInfo.destinationFrom.getSelectedItem()+" - "+FlightInfo.destinationTo.getSelectedItem());
                    PassengerInfo.travelGuestText.setText(String.valueOf(passengerInformation.getMaxPassenger()));
                    PassengerInfo.travelInsurance.setText(commaFormat.format(flightInformation.getInsurance())+".00");

                    if(flightInformation.getTripType()==1){
                        PassengerInfo.travelReturnFlightText.setText("          XX-XX-XX");
                    }else if(flightInformation.getTripType()==2){
                        PassengerInfo.travelReturnFlightText.setText(FlightInfo.destinationTo.getSelectedItem()+" - "+FlightInfo.destinationFrom.getSelectedItem());
                    }

                    // SIDE FOCUS
                    sideLine1.setFont(new Font("Leelawadee", Font.BOLD,13));
                    sideLine1.setForeground(new Color(94, 94, 92));
                    sideLine2.setFont(new Font("Leelawadee", Font.BOLD,18));
                    sideLine2.setForeground(new Color(255, 214, 98));
                    sideLine3.setFont(new Font("Leelawadee", Font.BOLD,13));
                    sideLine3.setForeground(new Color(94, 94, 92));

                    // ERROR REMOVED
                    error1.setVisible(false);
                    error2.setVisible(false);
                    error3.setVisible(false);

                    // DISPLAY PANELS
                    StartPage.setVisible(false);
                    Panel1.setVisible(false);
                    Panel2.setVisible(true);
                    Panel3.setVisible(false);

                }else{

                    // ERROR REMOVED
                    error1.setVisible(false);
                    error2.setVisible(false);
                    error3.setVisible(false);

                    if(flightInformation.getPlaneClass()==0){
                        error1.setVisible(true);
                    }
                    if(flightInformation.getLocation()==0){
                        error2.setVisible(true);
                    }
                    if(flightInformation.getTripType()==0){
                        error3.setVisible(true);
                    }

                    final Runnable runnable =
                            (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.exclamation");
                    if (runnable != null) runnable.run();
                }

            }


        };
    }

    // END OF ACTION LISTENER .......................................................................................//

    //PANEL 2 .......................................................................................................//

    public class PassengerInfo extends JPanel implements ActionListener{

        int counterPassenger=0;

        // BACKGROUND IMG
        public static JLabel background1= new JLabel();
        public static JLabel travelInsurance = new JLabel();

        // CLIENT SUMMARY
        public static JLabel travelGuestText= new JLabel();
        public static JLabel travelDepartureFlightText= new JLabel();
        public static JLabel travelReturnFlightText= new JLabel();

        // BUTTON NEXT PANEL 2
        ButtonCustom btnNextP2;
        ButtonCustom btnBackP2;

        // PASSENGER NUMBER TITLE
        JLabel labelPassengerTitle;

        // PASSENGER AGE
        JSpinner numAgeSpinner;
        SpinnerModel numAgeValue;

        // PASSENGER TEXTFIELD NAMES
        JTextField fieldFirstName;
        JTextField fieldLastName;

        // PASSENGER SEX
        JComboBox sexComboBox;

        // BAGGAGE NO.
        JSpinner numBaggageSpinner;
        SpinnerModel numBaggageValue;

        // INSURANCE NO.
        ButtonGroup insuranceGroup;
        RadioButtonCreator insuranceYesButton;
        RadioButtonCreator insuranceNoButton;

        // ERROR MESSAGES
        ErrorCreator errorPP1;
        ErrorCreator errorPP2;
        ErrorCreator errorPP3;

        PassengerInfo(){

            // BUTTON BACK

            btnBackP2 = new ButtonCustom("Back");
            btnBackP2.setFont(new Font("Leelawadee", Font.BOLD,18));
            btnBackP2.setBackground(new Color(21, 22, 24));
            btnBackP2.setForeground(new Color(194, 203, 208));
            btnBackP2.setBounds(760, 660, 120, 40);
            btnBackP2.setHoverBackgroundColor(new Color(32, 34, 37));
            btnBackP2.setPressedBackgroundColor(new Color(4, 28, 51));
            btnBackP2.setBorder(Panel1.Border_White);
            btnBackP2.setFocusable(false);
            btnBackP2.addActionListener(this);

            // BUTTON NEXT
            btnNextP2 = new ButtonCustom("Next");
            btnNextP2.setFont(new Font("Leelawadee", Font.BOLD,18));
            btnNextP2.setBackground(new Color(21, 22, 24));
            btnNextP2.setForeground(new Color(194, 203, 208));
            btnNextP2.setBounds(960, 660, 120, 40);
            btnNextP2.setHoverBackgroundColor(new Color(32, 34, 37));
            btnNextP2.setPressedBackgroundColor(new Color(4, 28, 51));
            btnNextP2.setBorder(Panel1.Border_White);
            btnNextP2.setFocusable(false);
            btnNextP2.addActionListener(this);

            // PASSENGER INFORMATION TITLE BAR

            JLabel labelPassenger = new JLabel("GUEST DETAILS", JLabel.LEFT);
            labelPassenger.setFont(new Font("Leelawadee", Font.BOLD,24));
            labelPassenger.setForeground(new Color(255, 214, 98));
            labelPassenger.setBounds(12,12,500,42);

            JPanel titlePassenger = new JPanel();
            titlePassenger.setBackground(new Color(1, 83, 157));
            titlePassenger.setBounds(0,0,775,60);

            JPanel titlePassengerline = new JPanel();
            titlePassengerline.setBackground(new Color(194, 203, 208));
            titlePassengerline.setBounds(0,60,775,2);

            // PASSENGER NUMBER......................................................................................//

            labelPassengerTitle = new JLabel("Passenger No. 01", JLabel.LEFT);
            labelPassengerTitle.setFont(new Font("Leelawadee", Font.BOLD,24));
            labelPassengerTitle.setForeground(new Color(194, 203, 208));
            labelPassengerTitle.setBounds(150,10,500,28);

            JPanel passengerTitlePanel = new JPanel();
            passengerTitlePanel.setBackground(new Color(65, 70, 74,255));
            passengerTitlePanel.setBounds(0,95,775,48);
            passengerTitlePanel.add(labelPassengerTitle);
            passengerTitlePanel.setLayout(null);

            // LABELS

            // NAME ..................................................................................................//

            TextCreator labelPF1= new TextCreator();
            labelPF1.setText("Name");
            labelPF1.setFont(new Font("Leelawadee", Font.BOLD,16));
            labelPF1.setForeground(new Color( 194, 203, 208));
            labelPF1.setBounds(30,160,100,20);

            TextCreator labelPF1A= new TextCreator();
            labelPF1A.setText("First Name");
            labelPF1A.setFont(new Font("Leelawadee", NORMAL,12));
            labelPF1A.setBounds(30,180,100,20);

            fieldFirstName= new JTextField();
            fieldFirstName.setText("");
            fieldFirstName.setFont(new Font("Leelawadee", NORMAL,13));
            fieldFirstName.setBackground(new Color(21, 22, 24));
            fieldFirstName.setForeground(new Color(194, 203, 208));
            fieldFirstName.setBounds(30,202,190,30);
            fieldFirstName.setBorder(Panel1.Border_White);
            fieldFirstName.addActionListener(this);

            TextCreator labelPF1B= new TextCreator();
            labelPF1B.setText("Last Name");
            labelPF1B.setFont(new Font("Leelawadee", NORMAL,12));
            labelPF1B.setBounds(278,180,100,20);

            fieldLastName= new JTextField();
            fieldLastName.setText("");
            fieldLastName.setFont(new Font("Leelawadee", NORMAL,13));
            fieldLastName.setBackground(new Color(21, 22, 24));
            fieldLastName.setForeground(new Color(194, 203, 208));
            fieldLastName.setBounds(280,202,190,30);
            fieldLastName.setBorder(Panel1.Border_White);

            // AGE ..................................................................................................//

            TextCreator labelPF2= new TextCreator();
            labelPF2.setText("Age");
            labelPF2.setFont(new Font("Leelawadee",Font.BOLD,16));
            labelPF2.setForeground(new Color( 194, 203, 208));
            labelPF2.setBounds(30,240,150,25);

            numAgeValue = new SpinnerNumberModel(0, 0, 100, 1);

            numAgeSpinner= new JSpinner(numAgeValue);
            numAgeSpinner.setBounds(30,268,100,30);
            numAgeSpinner.setEditor(new JSpinner.DefaultEditor(numAgeSpinner));
            numAgeSpinner.getEditor().getComponent(0).setBackground(new Color(21, 22, 24));
            numAgeSpinner.getEditor().getComponent(0).setForeground(new Color(194, 203, 208));
            numAgeSpinner.getEditor().getComponent(0).setFont(new Font("Leelawadee", Font.BOLD,14));

            // SEX  ..................................................................................................//

            TextCreator labelPF3= new TextCreator();
            labelPF3.setText("Sex");
            labelPF3.setFont(new Font("Leelawadee",Font.BOLD,16));
            labelPF3.setForeground(new Color( 194, 203, 208));
            labelPF3.setBounds(200,240,100,25);

            String[] SexComboBoxList= {"Male", "Female"};

            sexComboBox = new JComboBox(SexComboBoxList);
            sexComboBox.setBackground(new Color(21, 22, 24));
            sexComboBox.setForeground(new Color(194, 203, 208));
            sexComboBox.setBounds(200,268,120,29);
            sexComboBox.addActionListener(this);
            sexComboBox.setFocusable(false);

            // INSURANCE .............................................................................................//

            TextCreator labelPF4= new TextCreator();
            labelPF4.setText("Avail Insurance?");
            labelPF4.setFont(new Font("Leelawadee",Font.BOLD,16));
            labelPF4.setForeground(new Color( 194, 203, 208));
            labelPF4.setBounds(30,320,150,25);

            TextCreator labelPF4A= new TextCreator();
            labelPF4A.setText("Insurance Fee: ");
            labelPF4A.setFont(new Font("Leelawadee",NORMAL,13));
            labelPF4A.setForeground(new Color( 194, 203, 208));
            labelPF4A.setBounds(30,340,150,25);

            JLabel travelInsurancePeso = new JLabel("₱");
            travelInsurancePeso.setFont(new Font("Arial", NORMAL,14));
            travelInsurancePeso.setForeground(new Color(255, 214, 98));
            travelInsurancePeso.setBounds(123,342,100,20);

            travelInsurance.setFont(new Font("Leelawadee", NORMAL,14));
            travelInsurance.setForeground(new Color(255, 214, 98));
            travelInsurance.setBounds(136,342,100,20);

            JPanel travelInsuranceLine = new JPanel();
            travelInsuranceLine.setBackground(new Color(194, 203, 208));
            travelInsuranceLine.setBounds(120,362,80,1);

            insuranceYesButton = new RadioButtonCreator();
            insuranceYesButton.setText("Yes");
            insuranceYesButton.setBackground(new Color(38, 38, 38));
            insuranceYesButton.setBounds(195,320,50,22);
            insuranceYesButton.addActionListener(this);

            insuranceNoButton = new RadioButtonCreator();
            insuranceNoButton.setText("No");
            insuranceNoButton.setBackground(new Color(38, 38, 38));
            insuranceNoButton.setBounds(270,320,50,22);
            insuranceNoButton.addActionListener(this);

            insuranceGroup=new ButtonGroup();
            insuranceGroup.add(insuranceYesButton);
            insuranceGroup.add(insuranceNoButton);

            // ERROR MESSAGES

            errorPP1 = new ErrorCreator();
            ErrorCreator.warningText.setText("Please enter a valid name.");
            errorPP1.setBounds(90,163,200,15);
            errorPP1.setVisible(false);

            errorPP2 = new ErrorCreator();
            ErrorCreator.warningText.setText("Enter adult first.");
            errorPP2.setBounds(68,245,120,15);
            errorPP2.setVisible(false);

            errorPP3 = new ErrorCreator();
            ErrorCreator.warningText.setText("Please enter your insurance status.");
            errorPP3.setBounds(30,365,300,15);
            errorPP3.setVisible(false);

            // PASSENGER INFORMATION PANEL

            JPanel getPassengerInfoPanel = new JPanel();
            getPassengerInfoPanel.setBackground(new Color(38, 38, 38,255));
            getPassengerInfoPanel.setBounds(295,75,495,390);
            getPassengerInfoPanel.add(errorPP3);
            getPassengerInfoPanel.add(errorPP2);
            getPassengerInfoPanel.add(errorPP1);
            getPassengerInfoPanel.add(travelInsuranceLine);
            getPassengerInfoPanel.add(travelInsurance);
            getPassengerInfoPanel.add(travelInsurancePeso);
            getPassengerInfoPanel.add(insuranceYesButton);
            getPassengerInfoPanel.add(insuranceNoButton);
            getPassengerInfoPanel.add(labelPF4A);
            getPassengerInfoPanel.add(labelPF4);
            getPassengerInfoPanel.add(sexComboBox);
            getPassengerInfoPanel.add(numAgeSpinner);
            getPassengerInfoPanel.add(labelPF3);
            getPassengerInfoPanel.add(labelPF2);
            getPassengerInfoPanel.add(fieldFirstName);
            getPassengerInfoPanel.add(fieldLastName);
            getPassengerInfoPanel.add(labelPF1B);
            getPassengerInfoPanel.add(labelPF1A);
            getPassengerInfoPanel.add(labelPF1);
            getPassengerInfoPanel.add(passengerTitlePanel);
            getPassengerInfoPanel.add(titlePassengerline);
            getPassengerInfoPanel.add(labelPassenger);
            getPassengerInfoPanel.add(titlePassenger);
            getPassengerInfoPanel.setLayout(null);

            // TRAVEL INFORMATION SUMMARY ...........................................................................//

            JLabel labelFlightSum = new JLabel("FLIGHT SUMMARY", JLabel.LEFT);
            labelFlightSum.setFont(new Font("Leelawadee", Font.BOLD,20));
            labelFlightSum.setForeground(new Color(255, 214, 98));
            labelFlightSum.setBounds(12,12,500,42);

            JPanel titleFlightSum = new JPanel();
            titleFlightSum.setBackground(new Color(1, 83, 157));
            titleFlightSum.setBounds(0,0,775,60);

            JPanel titleFlightSumLine = new JPanel();
            titleFlightSumLine.setBackground(new Color(194, 203, 208));
            titleFlightSumLine.setBounds(0,60,775,2);

            // INFORMATION

            JLabel travelDepartureFlight = new JLabel("Departing Flight", JLabel.LEFT);
            travelDepartureFlight.setFont(new Font("Leelawadee", Font.BOLD,15));
            travelDepartureFlight.setForeground(new Color(194, 203, 208));
            travelDepartureFlight.setBounds(15,62,320,42);

            travelDepartureFlightText.setFont(new Font("Leelawadee", NORMAL,12));
            travelDepartureFlightText.setForeground(new Color(194, 203, 208));
            travelDepartureFlightText.setBounds(15,82,320,42);

            JLabel travelGuest = new JLabel("Guest/s", JLabel.LEFT);
            travelGuest.setFont(new Font("Leelawadee", Font.BOLD,15));
            travelGuest.setForeground(new Color(194, 203, 208));
            travelGuest.setBounds(185,62,320,42);

            JPanel travelGuestLine = new JPanel();
            travelGuestLine.setBackground(new Color(194, 203, 208));
            travelGuestLine.setBounds(216,110,18,1);

            travelGuestText.setFont(new Font("Leelawadee", NORMAL,12));
            travelGuestText.setForeground(new Color(255, 214, 98));
            travelGuestText.setBounds(220,82,320,42);

            JLabel travelReturningFlight = new JLabel("Returning Flight", JLabel.LEFT);
            travelReturningFlight.setFont(new Font("Leelawadee", Font.BOLD,15));
            travelReturningFlight.setForeground(new Color(194, 203, 208));
            travelReturningFlight.setBounds(15,112,320,42);

            travelReturnFlightText.setFont(new Font("Leelawadee", NORMAL,12));
            travelReturnFlightText.setForeground(new Color(194, 203, 208));
            travelReturnFlightText.setBounds(15,132,320,42);

            JPanel travelInfoSumPanel = new JPanel();
            travelInfoSumPanel.setBackground(new Color(38, 38, 38,255));
            travelInfoSumPanel.setBounds(825,75,255,175);
            travelInfoSumPanel.add(travelReturnFlightText);
            travelInfoSumPanel.add(travelReturningFlight);
            travelInfoSumPanel.add(travelGuestText);
            travelInfoSumPanel.add(travelGuestLine);
            travelInfoSumPanel.add(travelGuest);
            travelInfoSumPanel.add(travelDepartureFlightText);
            travelInfoSumPanel.add(travelDepartureFlight);
            travelInfoSumPanel.add(labelFlightSum);
            travelInfoSumPanel.add(titleFlightSumLine);
            travelInfoSumPanel.add(titleFlightSum);
            travelInfoSumPanel.setLayout(null);

            //Sub Panel

            setBackground(new Color(235, 236, 237));
            setBounds(0,0,1120,720);
            add(travelInfoSumPanel);
            add(getPassengerInfoPanel);
            add(btnBackP2);
            add(btnNextP2);
            add(background1);
            setLayout(null);
            setVisible(false);

        }

        // ACTION LISTENERS .........................................................................................//

        public void actionPerformed(ActionEvent e) {

            if(e.getSource()==btnBackP2){

                // ERROR MESSAGE REMOVED
                errorPP1.setVisible(false);
                errorPP2.setVisible(false);
                errorPP3.setVisible(false);

                labelPassengerTitle.setText("Passenger No. 01");
                fieldFirstName.setText("");
                fieldLastName.setText("");
                numAgeSpinner.setValue(0);
                sexComboBox.setSelectedIndex(0);
                insuranceGroup.clearSelection();
                counterPassenger=0;

                // SHOW PANELS
                StartPage.setVisible(false);
                Panel1.setVisible(true);
                Panel2.setVisible(false);
                Panel3.setVisible(false);

                // SIDE FOCUS
                sideLine1.setFont(new Font("Leelawadee", Font.BOLD,18));
                sideLine1.setForeground(new Color(255, 214, 98));
                sideLine2.setFont(new Font("Leelawadee", Font.BOLD,13));
                sideLine2.setForeground(new Color(94, 94, 92));
                sideLine3.setFont(new Font("Leelawadee", Font.BOLD,13));
                sideLine3.setForeground(new Color(94, 94, 92));

            }

            if (e.getSource() == btnNextP2) {

                // ARRAY STUFFS PASSENGER INFORMATION
                passengerInformation.setPassengerNumber(counterPassenger);

                // ERROR MESSAGES REMOVE
                errorPP1.setVisible(false);
                errorPP2.setVisible(false);
                errorPP3.setVisible(false);

                int checker=0;

                if(fieldFirstName.getText().matches("^[a-zA-Z_ -]*$")&& fieldLastName.getText().matches("^[a-zA-Z_ -]*$")){

                    if(fieldFirstName.getText().isEmpty()||fieldFirstName.getText().equals("")){
                        checker=1;
                        errorPP1.setVisible(true);
                    }else if(fieldLastName.getText().isEmpty()||fieldLastName.getText().equals("")){
                        checker=1;
                        errorPP1.setVisible(true);
                    }

                }else{
                    errorPP1.setVisible(true);
                }

                if((Integer) numAgeSpinner.getValue()<18 && counterPassenger==0){
                    checker=1;
                    errorPP2.setVisible(true);
                }

                if(insuranceYesButton.isSelected()==false && insuranceNoButton.isSelected()==false){
                    checker=1;
                    errorPP3.setVisible(true);
                }

                // SUCCESSFULLY ENTERED .............................................................................//
                if(checker==0) {
                    // ENTER DATA TO ARRAY
                    passengerInformation.setPassengerFirstName(fieldFirstName.getText());
                    passengerInformation.setPassengerLastName(fieldLastName.getText());
                    passengerInformation.setPassengerAge((Integer) numAgeSpinner.getValue());

                    if (sexComboBox.getSelectedItem().equals("Male")) {
                        passengerInformation.setPassengerSex(true);
                    } else if (sexComboBox.getSelectedItem().equals("Female")) {
                        passengerInformation.setPassengerSex(false);
                    }

                    if (insuranceYesButton.isSelected()) {
                        passengerInformation.setPassengerInsurance(true);
                    } else if (insuranceNoButton.isSelected()) {
                        passengerInformation.setPassengerInsurance(false);
                    }

                    // CHANGE PASSENGER NUMBER TITLE
                    if(passengerInformation.getPassengerNumber()<8) {
                        labelPassengerTitle.setText("Passenger No. 0" + String.valueOf(passengerInformation.getPassengerNumber() + 2));
                    }else{
                        labelPassengerTitle.setText("Passenger No. " + String.valueOf(passengerInformation.getPassengerNumber() + 2));
                    }

                    // REMOVE ENTERED DATA IN FIELDS
                    fieldFirstName.setText("");
                    fieldLastName.setText("");
                    numAgeSpinner.setValue(0);
                    sexComboBox.setSelectedIndex(0);
                    insuranceGroup.clearSelection();
                    counterPassenger++;

                    // PRINTING SUMMARY

                    if(flightInformation.getPlaneClass()==1){
                        FlightReceiptSummary.texttravelPlaneClassFRS.setText("PRIVATE CLASS");
                    }else if(flightInformation.getPlaneClass()==2){
                        FlightReceiptSummary.texttravelPlaneClassFRS.setText("BUSINESS CLASS");
                    }else if(flightInformation.getPlaneClass()==3){
                        FlightReceiptSummary.texttravelPlaneClassFRS.setText("REGULAR CLASS");
                    }

                    String fromloc, toloc;

                    fromloc=String.valueOf(FlightInfo.destinationFrom.getSelectedItem());
                    toloc=String.valueOf(FlightInfo.destinationTo.getSelectedItem());

                    FlightReceiptSummary.texttravelPassNoFRS.setText(String.valueOf(passengerInformation.getMaxPassenger()));
                    FlightReceiptSummary.texttravelDepartureFlightFRS.setText(fromloc.toUpperCase()+" - "+toloc.toUpperCase());
                    if(flightInformation.getTripType()==1){
                        FlightReceiptSummary.texttravelReturningFlightFRS.setText("NOT APPLICABLE");
                    }else if(flightInformation.getTripType()==2){
                        FlightReceiptSummary.texttravelReturningFlightFRS.setText(toloc.toUpperCase()+" - "+fromloc.toUpperCase());
                    }

                }else if(checker==1){
                    if (runnable != null) runnable.run();
                }

                if(counterPassenger==passengerInformation.getMaxPassenger()){

                    // INPUT TABLE INFORMATION
                    String data[][] = new String[passengerInformation.getMaxPassenger()][10];
                    String col[] = {"ID","Name","AGE","SEX","INSURANCE","PASSENGER FARE"};
                    int counterTable=0;
                    while(counterTable<passengerInformation.getMaxPassenger()){
                        passengerInfo.setPassengerNumber(counterTable);

                        if(counterTable<9) {
                            data[counterTable][0] = "0" + String.valueOf(counterTable + 1);
                        }else if(counterTable>=9){
                            data[counterTable][0] = String.valueOf(counterTable + 1);
                        }

                        data[counterTable][1]= passengerInfo.getPassengerFirstName()+" "+passengerInfo.getPassengerLastName();

                        if(passengerInfo.getPassengerSex()==true){
                            data[counterTable][3]="MALE";
                        }else if(passengerInfo.getPassengerSex()==false){
                            data[counterTable][3]="FEMALE";
                        }

                        // PRICES

                        double flightFare=flightInformation.getPrices();
                        double flightTaxFare=flightInformation.getPricesTaxPrices();
                        double flightBaggage=0;
                        double flightInsurance=flightInformation.getInsurance();
                        double flightFinalFare=0;
                        double flightType=flightInformation.getTripType();

                        if(flightInformation.getPlaneClass()==1){
                            flightBaggage=1250;
                        }else if(flightInformation.getPlaneClass()==2){
                            flightBaggage=2850;
                        }else if(flightInformation.getPlaneClass()==3){
                            flightBaggage=950;
                        }

                        data[counterTable][4]="YES";
                        if(passengerInformation.getPassengerInsurance()==false){
                            flightInsurance=0;
                            data[counterTable][4]="NO";
                        }

                        if(passengerInfo.getPassengerAge()<19){
                            data[counterTable][2]= "C - "+String.valueOf(passengerInfo.getPassengerAge());
                            flightFinalFare=flightFare+flightTaxFare+flightBaggage+flightInsurance;
                        }else if(passengerInfo.getPassengerAge()>=19 && passengerInfo.getPassengerAge()<= 59 ){
                            data[counterTable][2]= "A - "+String.valueOf(passengerInfo.getPassengerAge());
                            flightFinalFare=flightFare+flightTaxFare+flightBaggage+flightInsurance;
                        }else if(passengerInfo.getPassengerAge()>59){
                            data[counterTable][2]= "S - "+String.valueOf(passengerInfo.getPassengerAge());
                            flightFinalFare=(flightFare+flightBaggage+flightInsurance)*0.8;
                        }

                        passengerInfo.setPassengerTotalPrice(flightFinalFare);
                        finalTotalPrice+=flightFinalFare;

                        data[counterTable][5]="PHP "+String.valueOf(commaFormat.format(passengerInfo.getPassengerTotalPrice()));

                        counterTable++;
                    }
                    if(flightInformation.getPlaneClass()==1 ||flightInformation.getPlaneClass()==2){
                        finalTotalPrice+=550;
                    }else if(flightInformation.getPlaneClass()==3 ){
                        finalTotalPrice+=255;
                    }
                    FlightReceiptSummary.flightFinalPriceTextEntered.setText("PHP "+String.valueOf(commaFormat.format(finalTotalPrice)));


                    // TABLE COMPONENTS
                    table = new JTable(data,col);

                    // TABLE
                    header = table.getTableHeader();
                    header.setFont(new Font("Leelawadee", Font.BOLD,16));
                    header.setForeground(new Color(194, 203, 208));
                    header.setBackground(new Color(1, 83, 157));

                    // PANE
                    pane = new JScrollPane(table);
                    pane.setVisible(true);
                    pane.setEnabled(true);

                    // TABLE ATTRIBUTES
                    table.setFont(new Font("Leelawadee", NORMAL,13));
                    table.setForeground(new Color(194, 203, 208));
                    table.setBackground(new Color(32, 34, 37));
                    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                    table.setEnabled(false);
                    table.setPreferredSize(new Dimension(620,275));
                    table.getColumnModel().getColumn(0).setPreferredWidth(10);
                    table.getColumnModel().getColumn(1).setPreferredWidth(150);
                    table.getColumnModel().getColumn(2).setPreferredWidth(50);
                    table.getColumnModel().getColumn(3).setPreferredWidth(50);
                    table.getColumnModel().getColumn(4).setPreferredWidth(100);
                    table.getColumnModel().getColumn(5).setPreferredWidth(150);
                    table.setPreferredScrollableViewportSize(table.getPreferredSize());
                    //table.setFillsViewportHeight(true);

                    // PANEL TABLE
                    panelTable.add(pane);
                    panelTable.setBackground(new Color(32, 34, 37));
                    panelTable.setBounds(12,150,622,306);

                    // SIDE FOCUS
                    sideLine1.setFont(new Font("Leelawadee", Font.BOLD,13));
                    sideLine1.setForeground(new Color(94, 94, 92));
                    sideLine2.setFont(new Font("Leelawadee", Font.BOLD,13));
                    sideLine2.setForeground(new Color(94, 94, 92));
                    sideLine3.setFont(new Font("Leelawadee", Font.BOLD,18));
                    sideLine3.setForeground(new Color(255, 214, 98));

                    // DISPLAY PANELS
                    Panel1.setVisible(false);
                    Panel2.setVisible(false);
                    Panel3.setVisible(true);
                    StartPage.setVisible(false);
                }

            }
        }
    }

    // PANEL 3 .......................................................................................................//

    public class FlightReceiptSummary extends JPanel implements ActionListener{

        // BACKGROUND IMG
        public static JLabel background2=new JLabel();

        // LABEL INFORMATIONS
        public static JLabel texttravelPlaneClassFRS = new JLabel();
        public static JLabel texttravelPassNoFRS = new JLabel();
        public static JLabel texttravelDepartureFlightFRS = new JLabel();
        public static JLabel texttravelReturningFlightFRS = new JLabel();
        public static JLabel flightFinalPriceTextEntered = new JLabel();

        public static ButtonCustom btnNextP3 = new ButtonCustom();

        FlightReceiptSummary(){

            // BACKGROUND
            background2.setIcon(manilaImgBackground);
            background2.setBounds(250,25,1000,700);

            //RANDOMIZER

            Random random = new Random();

            String randomGen="";

            String setOfCharacters = "abcdefghijklmnopqrxyz123456789";

            int counterRandom=0;
            while(counterRandom<6) {
                int randomInt = random.nextInt(setOfCharacters.length());
                char randomChar = setOfCharacters.charAt(randomInt);
                randomGen=randomGen+randomChar;
                counterRandom++;
            }

            JLabel labelRandomTitle = new JLabel(randomGen.toUpperCase(), JLabel.RIGHT);
            labelRandomTitle.setFont(new Font("Leelawadee", Font.BOLD,24));
            labelRandomTitle.setForeground(new Color(255, 214, 98));
            labelRandomTitle.setBounds(412,12,200,42);

            // FLIGHT SUMMARY TITLE

            // BUTTON NEXT
            btnNextP3 = new ButtonCustom("Confirm");
            btnNextP3.setFont(new Font("Leelawadee", Font.BOLD,18));
            btnNextP3.setBackground(new Color(21, 22, 24));
            btnNextP3.setForeground(new Color(194, 203, 208));
            btnNextP3.setBounds(970, 660, 120, 40);
            btnNextP3.setHoverBackgroundColor(new Color(32, 34, 37));
            btnNextP3.setPressedBackgroundColor(new Color(4, 28, 51));
            btnNextP3.setBorder(Panel1.Border_White);
            btnNextP3.setFocusable(false);
            btnNextP3.addActionListener(this);

            JLabel labelSummaryTitle = new JLabel("Flight Summary", JLabel.LEFT);
            labelSummaryTitle.setFont(new Font("Leelawadee", Font.BOLD,24));
            labelSummaryTitle.setForeground(new Color(255, 214, 98));
            labelSummaryTitle.setBounds(12,12,500,42);

            JPanel titleSummary = new JPanel();
            titleSummary.setBackground(new Color(1, 83, 157));
            titleSummary.setBounds(0,0,875,60);

            JPanel titleSummaryLine= new JPanel();
            titleSummaryLine.setBackground(new Color(194, 203, 208));
            titleSummaryLine.setBounds(0,60,875,2);

            JPanel titleSummaryLine1= new JPanel();
            titleSummaryLine1.setBackground(new Color(194, 203, 208));
            titleSummaryLine1.setBounds(0,142,875,2);

           // DETAILS

            JPanel titleHighlight= new JPanel();
            titleHighlight.setBackground(new Color(32, 34, 37));
            titleHighlight.setBounds(0,142,875,350);

            // PLANE CLASS

            JLabel travelPlaneClassFRS = new JLabel("Plane Class:", JLabel.LEFT);
            travelPlaneClassFRS.setFont(new Font("Leelawadee", Font.BOLD,15));
            travelPlaneClassFRS.setForeground(new Color(194, 203, 208));
            travelPlaneClassFRS.setBounds(20,62,320,42);

            texttravelPlaneClassFRS.setText("PRIVATE");

            texttravelPlaneClassFRS.setFont(new Font("Leelawadee", NORMAL,14));
            texttravelPlaneClassFRS.setForeground(new Color(194, 203, 208));
            texttravelPlaneClassFRS.setBounds(118,73,150,20);

            JPanel travelPlaneClassLFRS= new JPanel();
            travelPlaneClassLFRS.setBackground(new Color(194, 203, 208));
            travelPlaneClassLFRS.setBounds(115,92,150,1);

            // NUM OF PASSENGER

            JLabel travelPassNoFRS = new JLabel("Number of Passenger:", JLabel.LEFT);
            travelPassNoFRS.setFont(new Font("Leelawadee", Font.BOLD,15));
            travelPassNoFRS.setForeground(new Color(194, 203, 208));
            travelPassNoFRS.setBounds(20,92,320,42);

            texttravelPassNoFRS.setText("13");

            texttravelPassNoFRS.setFont(new Font("Leelawadee", NORMAL,14));
            texttravelPassNoFRS.setForeground(new Color(194, 203, 208));
            texttravelPassNoFRS.setBounds(188,103,150,20);

            JPanel travelPassNoLFRS= new JPanel();
            travelPassNoLFRS.setBackground(new Color(194, 203, 208));
            travelPassNoLFRS.setBounds(185,122,80,1);

            // DEPARTING FLIGHT

            JLabel travelDepartureFlightFRS = new JLabel("Departing Flight:", JLabel.LEFT);
            travelDepartureFlightFRS.setFont(new Font("Leelawadee", Font.BOLD,15));
            travelDepartureFlightFRS.setForeground(new Color(194, 203, 208));
            travelDepartureFlightFRS.setBounds(295,62,320,42);

            texttravelDepartureFlightFRS.setText("MANILA - BATANES");

            texttravelDepartureFlightFRS.setFont(new Font("Leelawadee", NORMAL,14));
            texttravelDepartureFlightFRS.setForeground(new Color(194, 203, 208));
            texttravelDepartureFlightFRS.setBounds(433,73,250,20);

            JPanel travelDepartureFlightLFRS= new JPanel();
            travelDepartureFlightLFRS.setBackground(new Color(194, 203, 208));
            travelDepartureFlightLFRS.setBounds(430,92,180,1);

            // RETURNING FLIGHT

            JLabel travelReturningFlightFRS = new JLabel("Returning Flight:", JLabel.LEFT);
            travelReturningFlightFRS.setFont(new Font("Leelawadee", Font.BOLD,15));
            travelReturningFlightFRS.setForeground(new Color(194, 203, 208));
            travelReturningFlightFRS.setBounds(295,92,320,42);

            texttravelReturningFlightFRS.setText("BATANES - MANILA");

            texttravelReturningFlightFRS.setFont(new Font("Leelawadee", NORMAL,14));
            texttravelReturningFlightFRS.setForeground(new Color(194, 203, 208));
            texttravelReturningFlightFRS.setBounds(433,103,250,20);

            JPanel travelReturningFlightLFRS= new JPanel();
            travelReturningFlightLFRS.setBackground(new Color(194, 203, 208));
            travelReturningFlightLFRS.setBounds(430,122,180,1);

            // FLIGHT SUMMARY PANEL

            JPanel finalTravelInfoSumPanel = new JPanel();
            finalTravelInfoSumPanel.setBackground(new Color(21, 22, 24,255));
            finalTravelInfoSumPanel.setBounds(295,75,650,475);
            finalTravelInfoSumPanel.add(labelRandomTitle);
            finalTravelInfoSumPanel.add(panelTable);
            finalTravelInfoSumPanel.add(texttravelReturningFlightFRS);
            finalTravelInfoSumPanel.add(texttravelDepartureFlightFRS);
            finalTravelInfoSumPanel.add(texttravelPassNoFRS);
            finalTravelInfoSumPanel.add(texttravelPlaneClassFRS);
            finalTravelInfoSumPanel.add(travelReturningFlightLFRS);
            finalTravelInfoSumPanel.add(travelDepartureFlightLFRS);
            finalTravelInfoSumPanel.add(travelPassNoLFRS);
            finalTravelInfoSumPanel.add(travelPlaneClassLFRS);
            finalTravelInfoSumPanel.add(travelPassNoFRS);
            finalTravelInfoSumPanel.add(travelPlaneClassFRS);
            finalTravelInfoSumPanel.add(travelDepartureFlightFRS);
            finalTravelInfoSumPanel.add(travelReturningFlightFRS);
            finalTravelInfoSumPanel.add(labelSummaryTitle);
            finalTravelInfoSumPanel.add(titleSummaryLine1);
            finalTravelInfoSumPanel.add(titleSummaryLine);
            finalTravelInfoSumPanel.add(titleHighlight);
            finalTravelInfoSumPanel.add(titleSummary);
            finalTravelInfoSumPanel.setLayout(null);

            JLabel flightFinalPriceText = new JLabel("OVERALL COST:", JLabel.LEFT);
            flightFinalPriceText.setFont(new Font("Leelawadee", Font.BOLD,20));
            flightFinalPriceText.setForeground(new Color(255, 214, 98));
            flightFinalPriceText.setBounds(10,5,320,30);

            JPanel flightFinalPriceLabel = new JPanel();
            flightFinalPriceLabel.setFont(new Font("Leelawadee", Font.BOLD,20));
            flightFinalPriceLabel.setBackground(new Color(1, 83, 157));
            flightFinalPriceLabel.setBounds(0,0,290,38);

            JPanel flightFinalPriceTextL= new JPanel();
            flightFinalPriceTextL.setBackground(new Color(194, 203, 208));
            flightFinalPriceTextL.setBounds(0,37,290,1);

            flightFinalPriceTextEntered.setText("PHP 1,000.00");

            flightFinalPriceTextEntered.setFont(new Font("Leelawadee", NORMAL,16));
            flightFinalPriceTextEntered.setForeground(new Color(194, 203, 208));
            flightFinalPriceTextEntered.setBounds(12,50,150,20);

            JPanel flightFinalPriceTextLL= new JPanel();
            flightFinalPriceTextLL.setBackground(new Color(194, 203, 208));
            flightFinalPriceTextLL.setBounds(10,72,148,1);

            JPanel flightFinalPrice = new JPanel();
            flightFinalPrice.setBackground(new Color(38, 38, 38,255));
            flightFinalPrice.setBounds(655,580,290,92);
            flightFinalPrice.add(flightFinalPriceTextEntered);
            flightFinalPrice.add(flightFinalPriceTextLL);
            flightFinalPrice.add(flightFinalPriceTextL);
            flightFinalPrice.add(flightFinalPriceText);
            flightFinalPrice.add(flightFinalPriceLabel);
            flightFinalPrice.setLayout(null);

            setBackground(new Color(235, 236, 237));
            setBounds(0,0,1120,720);
            add(flightFinalPrice);
            add(finalTravelInfoSumPanel);
            add(btnNextP3);
            add(background2);
            setLayout(null);
            setVisible(false);

        }

        public void actionPerformed(ActionEvent e){
            if(e.getSource()==btnNextP3){
                System.exit(0);
            }
        }

    }

    // START PAGE SWED AIRLINES ......................................................................................//

    public class StartPageSWED extends JPanel implements ActionListener{

        // BACKGROUND IMG
        public static JLabel background3=new JLabel();

        // BUTTON NEXT
        public static ButtonCustom btnGetStarted = new ButtonCustom();

        StartPageSWED(){

            btnGetStarted.setText("GET STARTED");
            btnGetStarted.setFont(new Font("Leelawadee", Font.BOLD,24));
            btnGetStarted.setBackground(new Color(21, 22, 24));
            btnGetStarted.setForeground(new Color(194, 203, 208));
            btnGetStarted.setBounds(880, 630, 200, 50);
            btnGetStarted.setHoverBackgroundColor(new Color(32, 34, 37));
            btnGetStarted.setPressedBackgroundColor(new Color(4, 28, 51));
            btnGetStarted.setBorder(Panel1.Border_White);
            btnGetStarted.setFocusable(false);
            btnGetStarted.addActionListener(this);

            background3.setIcon(mainPage);
            background3.setBounds(250,25,1000,700);

            setBackground(new Color(235, 236, 237));
            setBounds(0,0,1120,720);
            add(btnGetStarted);
            add(background3);
            setLayout(null);

        }

        public void actionPerformed(ActionEvent e){

            if(e.getSource()==btnGetStarted){

                sideLine1.setFont(new Font("Leelawadee", Font.BOLD,18));
                sideLine1.setForeground(new Color(255, 214, 98));
                sideLine2.setFont(new Font("Leelawadee", Font.BOLD,13));
                sideLine2.setForeground(new Color(94, 94, 92));
                sideLine3.setFont(new Font("Leelawadee", Font.BOLD,13));
                sideLine3.setForeground(new Color(94, 94, 92));
                sideLine1.setVisible(true);
                sideLine2.setVisible(true);
                sideLine3.setVisible(true);

                // DISPLAY PANELS
                StartPage.setVisible(false);
                Panel1.setVisible(true);
                Panel2.setVisible(false);
                Panel3.setVisible(false);
            }

        }

    }

    // MAIN CONSTRUCTOR .............................................................................................//

        public PROJECT_FINAL() {

    // FIXED PANELS

        // UPPER PANELS

           JLabel labelExitHover = new JLabel();
           JLabel labelExit = new JLabel();

            labelExit.setIcon(new ImageIcon(logoExit.getImage().getScaledInstance(22, 22, Image.SCALE_SMOOTH)));
            labelExit.setBounds(1094,4,550,22);
            labelExit.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    labelExitHover.setVisible(true);
                }
            });

            labelExitHover.setIcon(new ImageIcon(logoExitHover.getImage().getScaledInstance(22, 22, Image.SCALE_SMOOTH)));
            labelExitHover.setBounds(1094,4,550,22);
            labelExitHover.setVisible(false);
            labelExitHover.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    System.exit(0);
                }
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    labelExitHover.setVisible(false);
                }
            });

            JPanel upperPanel = new JPanel();
            upperPanel.setBackground(new Color(21, 22, 24));
            upperPanel.setBounds(0, 0, 1120, 30);
            upperPanel.add(labelExitHover);
            upperPanel.add(labelExit);
            upperPanel.setLayout(null);

        // SIDE PANELS

            //texts
            JLabel uppertitle = new JLabel("TM.", JLabel.LEFT);
            uppertitle.setFont(new Font("Leelawadee", NORMAL,8));
            uppertitle.setForeground(new Color(194, 203, 208));
            uppertitle.setBounds(220,55+95,300,42);

            JLabel title = new JLabel("SWED AIRLINES", JLabel.LEFT);
            title.setFont(new Font("BEBAS NEUE", NORMAL,42));
            title.setForeground(new Color(255, 214, 98));
            title.setBounds(29,80+95,300,42);

            JLabel JLlogo = new JLabel();
            JLlogo.setIcon(new ImageIcon(logoImg.getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH)));
            JLlogo.setBounds(56,25,550,140);

            JLabel subtitle = new JLabel("Fly high, serves the sky.", JLabel.LEFT);
            subtitle.setFont(new Font("Leelawadee", NORMAL,13));
            subtitle.setForeground(new Color(194, 203, 208));
            subtitle.setBounds(29,105+95,300,42);

            JLabel Copyright = new JLabel("© SWED AIRLINES. All Rights Reserved.", JLabel.LEFT);
            Copyright.setFont(new Font("Leelawadee", NORMAL,11));
            Copyright.setForeground(new Color(194, 203, 208));
            Copyright.setBounds(29,550+90,300,42);

            JPanel sideLine = new JPanel();
            sideLine.setBackground(new Color(194, 203, 208));
            sideLine.setBounds(29,250,188,1);

            sideLine1 = new JLabel("FLIGHT INFORMATION", JLabel.LEFT);
            sideLine1.setFont(new Font("Leelawadee", Font.BOLD,13));
            sideLine1.setForeground(new Color(94, 94, 92));
            sideLine1.setBounds(29,300,300,42);
            sideLine1.setVisible(false);

            sideLine2 = new JLabel("GUEST DETAILS", JLabel.LEFT);
            sideLine2.setFont(new Font("Leelawadee", Font.BOLD,13));
            sideLine2.setForeground(new Color(94, 94, 92));
            sideLine2.setBounds(29,350,300,42);
            sideLine2.setVisible(false);

            sideLine3 = new JLabel("FLIGHT SUMMARY", JLabel.LEFT);
            sideLine3.setFont(new Font("Leelawadee", Font.BOLD,13));
            sideLine3.setForeground(new Color(94, 94, 92));
            sideLine3.setBounds(29,400,300,42);
            sideLine3.setVisible(false);

            JPanel sidePanel1 = new JPanel();
            sidePanel1.setBackground(new Color(32, 34, 37));
            sidePanel1.setBounds(0, 30, 250, 720);
            sidePanel1.add(sideLine);
            sidePanel1.add(sideLine1);
            sidePanel1.add(sideLine2);
            sidePanel1.add(sideLine3);
            sidePanel1.add(title);
            sidePanel1.add(subtitle);
            sidePanel1.add(uppertitle);
            sidePanel1.add(JLlogo);
            sidePanel1.add(Copyright);
            sidePanel1.setLayout(null);

        //FRAME ATTRIBUTES

            setSize(new Dimension(1120, 720));
            setResizable(false);
            setUndecorated(true);
            getContentPane().setBackground(new Color(235, 236, 237));
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            setLayout(null);
            setLocationRelativeTo(null);
            add(sidePanel1);
            add(upperPanel);

            //TEMPORARY
            //Panel1.setVisible(true);
            //Panel2.setVisible(true);
            //Panel3.setVisible(true);

            add(Panel3);
            add(Panel2);
            add(Panel1);
            add(StartPage);

        }

    }

