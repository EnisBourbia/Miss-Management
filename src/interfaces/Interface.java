package interfaces;

import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;


abstract public class Interface {
    private AnchorPane gui;
    private String title;

    public Interface(){
        this.gui = this.showGUI();
        this.title = "Miss Management";
    }

    public GridPane getTitlePane(String titleText){
        GridPane grid = new GridPane();

        grid.setVgap(10);
        grid.setHgap(5);
        Label title = new Label(titleText);

        GridPane.setConstraints(title, 0, 0);
        grid.getChildren().add(title);

        title.getStyleClass().add("title");
        grid.getStyleClass().add("grid");
        grid.getStyleClass().add("bg");

        return grid;
    }

    abstract public AnchorPane showGUI();

    public String getTitle(){
        return this.title;
    }


    public AnchorPane getGUI(){
        return this.gui;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    // main menu
    Button registerBtn = new Button("Register");
    Button loginBtn = new Button("Login");

    // login
    Hyperlink registerLink = new Hyperlink("Create an account instead");
    Button submitLoginBtn = new Button("Login");

    // register
    TextField userFirstName  = new TextField();
    TextField userLastName = new TextField();

    Hyperlink loginLink = new Hyperlink("Login instead");

    PasswordField userPasswordConfirm = new PasswordField();

    Button createAccBtn = new Button ("Create account");

    // register + login

    Hyperlink mainMenuLink = new Hyperlink("Back to Main Menu");
    TextField userEmail = new TextField();
    PasswordField userPassword = new PasswordField();


    // various input screens

    Label debug = new Label();

    // user menu
    Button createAProjectBtn = new Button("Create a project");
    Button projectsBtn = new Button("Current projects");
    Button closeAProjectBtn = new Button("Close a project");
    Button pastProjectsBtn = new Button("Past projects");
    Button notificationsBtn = new Button ("Notifications");

    Label userMenuLabel = new Label();

    public Label getUserMenuLabel(){
        return this.userMenuLabel;
    }


    public Button getPastProjectsBtn(){
        return this.pastProjectsBtn;
    }
    public Button getCloseAProjectBtn(){
        return this.closeAProjectBtn;
    }

    public Button getNotificationsBtn(){
        return this.notificationsBtn;
    }

    Hyperlink logoutLink = new Hyperlink("Log out");

    // close a project

    ChoiceBox<String> projectsCb = new ChoiceBox<>();

    public ChoiceBox<String> getProjectsCb(){
        return this.projectsCb;
    }

    Button closeProjectBtn = new Button("Close project");

    public Button getCloseProjectBtn(){
        return this.closeProjectBtn;
    }

    // create a project + current projects
    Hyperlink backToUserMenu = new Hyperlink("Back to User Menu");

    // create a project
    Button createProjectBtn = new Button ("Create project");

    TextField projectName = new TextField();
    TextArea projectDescription = new TextArea();

    // manage project
    Hyperlink backToCurrentProjects = new Hyperlink("Back to Current Projects");

    Label projectNameLabel = new Label();
    Label projectDescLabel = new Label();

    Button tasksBtn = new Button("Tasks");

    public Button getTasksBtn(){
        return this.tasksBtn;
    }
    Button addUserBtn = new Button("Add users");
    Button addSalaryBtn = new Button("Add Salary");
    Button currentSalariesBtn = new Button("Costs");

    // manage project sub screens
    Hyperlink backToManageProject = new Hyperlink("Back to Manage Project");
    Hyperlink backToCurrentTasks = new Hyperlink("Back to Current Tasks");

    // add user
    Button addUserConfirmBtn = new Button("Add user");
    ChoiceBox<String> userRolesCb = new ChoiceBox<>();

    // task menu
    Button createTaskBtn = new Button("Create a task");
    Button currentTasksBtn = new Button("Current Tasks");
    Button allTasksBtn = new Button("View all project tasks");
    Button logHoursBtn = new Button("Log hours");

    Hyperlink backToTaskMenu = new Hyperlink("Back to Task Menu");


    // create a task
    TextField taskName = new TextField();
    TextArea taskDesc = new TextArea();
    Button createATaskBtn = new Button("Create task");
    ChoiceBox<String> assignUserCB = new ChoiceBox<>();

    public ChoiceBox<String> getAssignUserCB(){
        return this.assignUserCB;
    }


    // current tasks
    Label taskNameLabel = new Label();
    Label taskDescLabel = new Label();
    Label taskProgressLabel = new Label();

    // log hours
    TextField hoursInput = new TextField();
    Button addHoursBtn = new Button("Add hours");

    public TextField getHoursInput(){
        return this.hoursInput;
    }

    public Button getAddHoursBtn(){
        return this.addHoursBtn;
    }

    // salary
    ChoiceBox<String> allUsersCB = new ChoiceBox<>();

    TextField hourSalary = new TextField();

    // meeting
    Hyperlink backToMeetingMenu = new Hyperlink("Back to Meeting Menu");

    Button showMeetingMenuBtn = new Button("Meetings");
    Button createNewMeetingBtn = new Button ("Create a new meeting");
    Button createNewMeetingInviteBtn = new Button ("Invite team to meeting");
    Button meetingScheduleBtn = new Button("Upcoming meetings");
    Button pastMeetingsBtn = new Button("Past meetings");

    public Button getMeetingScheduleBtn(){
        return this.meetingScheduleBtn;
    }

    public Button getPastMeetingsBtn(){
        return this.pastMeetingsBtn;
    }


    TextField meetingLocation = new TextField();
    TextField userEmailMeeting = new TextField();

    DatePicker meetingDate = new DatePicker();


    // admin

    Button userExportBtn = new Button("Export all data");

    // main menu
    public Button getRegisterBtn(){
        return this.registerBtn;
    }
    public Button getLoginBtn(){
        return this.loginBtn;
    }

    // login
    public Hyperlink getRegisterLink(){
        return this.registerLink;
    }

    public Button getSubmitLoginBtn(){
        return this.submitLoginBtn;
    }

    // register
    public TextField getUserFirstName(){
        return this.userFirstName;
    }

    public TextField getUserLastName(){
        return this.userLastName;
    }

    public PasswordField getUserPasswordConfirm(){
        return this.userPasswordConfirm;
    }

    public Button getCreateAccBtn(){
        return this.createAccBtn;
    }

    public Hyperlink getLoginLink(){
        return this.loginLink;
    }

    // login + register
    public TextField getUserEmail(){
        return this.userEmail;
    }

    public PasswordField getUserPassword(){
        return this.userPassword;
    }

    public Hyperlink getMainMenuLink(){
        return this.mainMenuLink;
    }

    // various input screens

    public Label getDebug(){
        return this.debug;
    }

    // user menu
    public Hyperlink getLogoutLink(){
        return this.logoutLink;
    }

    public Button getCreateAProjectBtn(){
        return this.createAProjectBtn;
    }

    public Button getProjectsBtn(){
        return this.projectsBtn;
    }

    // create a project + current projects
    public Hyperlink getBackToUserMenuLink(){
        return  this.backToUserMenu;
    }


    //create a project
    public Button getCreateProjectBtn(){
        return this.createProjectBtn;
    }

    public TextField getProjectName(){
        return this.projectName;
    }

    public TextArea getProjectDescription(){
        return this.projectDescription;
    }

    // current projects

    // manage project
    public Hyperlink getBackToCurrentProjects(){
        return this.backToCurrentProjects;
    }

    public Label getProjectNameLabel(){
        return this.projectNameLabel;
    }

    public Label getProjectDescLabel(){
        return this.projectDescLabel;
    }

    public Button getAddUserBtn(){
        return this.addUserBtn;
    }

    public Button getCurrentSalariesBtn() {
        return currentSalariesBtn;
    }


    // add salary + manage project

    public Button getAddSalaryBtn(){
        return addSalaryBtn;
    }

    // manage project sub screens
    public Hyperlink getBackToManageProject(){
        return this.backToManageProject;
    }

    // add a user
    public ChoiceBox<String> getUserRolesCb(){
        return this.userRolesCb;
    }

    public Button getAddUserConfirmBtn(){
        return this.addUserConfirmBtn;
    }

    // task menu
    public Hyperlink getBackToTaskMenu(){
        return this.backToTaskMenu;
    }

    public Button getCreateATaskBtn(){
        return this.createATaskBtn;
    }

    public Button getCurrentTasksBtn(){
        return this.currentTasksBtn;
    }

    public Button getAllTasksBtn(){
        return this.allTasksBtn;
    }

    public Button getLogHoursBtn(){
        return this.logHoursBtn;
    }

    // create a task

    public TextField getTaskName(){
        return this.taskName;
    }

    public TextArea getTaskDesc(){
        return this.taskDesc;
    }

    public Button getCreateTaskBtn(){
        return this.createTaskBtn;
    }

    // current tasks

    // manage tasks
    public Label getTaskNameLabel(){
        return this.taskNameLabel;
    }

    public Label getTaskDescLabel(){
        return this.taskDescLabel;
    }

    public Label getTaskProgressLabel(){
        return this.taskProgressLabel;
    }

    public Hyperlink getBackToCurrentTasks(){
        return this.backToCurrentTasks;
    }

    // log hours

    // add salary
    public TextField getHourSalary(){
        return this.hourSalary;
    }

    public ChoiceBox<String> getAllUsersCB(){
        return this.allUsersCB;
    }

    // meeting
    public TextField getMeetingLocation() {
        return this.meetingLocation;
    }

    public TextField getUserEmailMeeting() {
        return this.userEmailMeeting;
    }

    public Button getShowMeetingMenuBtn(){
        return this.showMeetingMenuBtn;
    }

    public Button getCreateNewMeetingBtn() {
        return this.createNewMeetingBtn;
    }

    public Button getCreateNewMeetingInviteBtn() {
        return this.createNewMeetingInviteBtn;
    }

    public DatePicker getMeetingDate() {
        return this.meetingDate;
    }

    public Hyperlink getBackToMeetingMenu() {
        return this.backToMeetingMenu;
    }

    // admin

    public Button getUserExportBtn(){
        return this.userExportBtn;
    }




}
