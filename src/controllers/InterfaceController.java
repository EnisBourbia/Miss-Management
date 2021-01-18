package controllers;

import interfaces.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import projects.*;
import tools.*;
import users.*;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class InterfaceController  {

    private Stage stage;
    private Scene scene;
    private User currentUser;
    private AnchorPane gui;
    private MainMenuInterface mainMenuInterface;
    private RegisterInterface registerInterface;
    private LoginInterface loginInterface;
    private UserInterface userInterface;
    private CreateProjectInterface createProjectInterface;
    private UserProjectsInterface userProjectsInterface;
    private CloseProjectInterface closeProjectInterface;
    private PastProjectsInterface pastProjectsInterface;
    private ManageProjectInterface manageProjectInterface;
    private UserMeetingInterface userMeetingInterface;
    private CreateMeetingInterface createMeetingInterface;
    private MeetingScheduleInterface meetingScheduleInterface;
    private PastMeetingsInterface pastMeetingsInterface;
    private AddUserInterface addUserInterface;
    private TaskMenuInterface taskMenuInterface;
    private CreateTaskInterface createTaskInterface;
    private UserTasksInterface userTasksInterface;
    private ManageTaskInterface manageTaskInterface;
    private AllProjectTasksInterface allProjectTasksInterface;
    private NotificationInterface notificationInterface;

    private LogHoursInterface logHoursInterface;
    private UserSalaryInterface userSalaryInterface;
    private AddSalaryInterface addSalaryInterface;
    private AdminInterface adminInterface;

    private ProjectLibrary projectLibrary;
    private UserLibrary userLibrary;
    private SysAdminLibrary sysAdminLibrary;
    private TaskLibrary taskLibrary;
    private RoleLibrary roleLibrary;
    private SalaryLibrary salaryLibrary;
    private MeetingLibrary meetingLibrary;
    private NotificationLibrary notificationLibrary;


    private Email emailFunction;


    public InterfaceController(Stage stage){
        this.stage = stage;
        this.gui = new AnchorPane();
        this.scene = new Scene(gui,900,700);
        this.mainMenuInterface = new MainMenuInterface();
        this.registerInterface = new RegisterInterface();
        this.loginInterface = new LoginInterface();

      //  this.currentUser = new User("email@email.com", "firstName", "lastName", "password");

        this.userInterface = new UserInterface();
        this.createProjectInterface = new CreateProjectInterface();
        this.userProjectsInterface = new UserProjectsInterface();
        this.notificationInterface = new NotificationInterface();
        this.createProjectInterface = new CreateProjectInterface();
        this.closeProjectInterface = new CloseProjectInterface();
        this.pastProjectsInterface = new PastProjectsInterface();
        this.manageProjectInterface = new ManageProjectInterface();
        this.userMeetingInterface = new UserMeetingInterface();
        this.createMeetingInterface = new CreateMeetingInterface();
        this.meetingScheduleInterface = new MeetingScheduleInterface();
        this.pastMeetingsInterface = new PastMeetingsInterface();
        this.addUserInterface = new AddUserInterface();
        this.taskMenuInterface = new TaskMenuInterface();
        this.createTaskInterface = new CreateTaskInterface();
        this.userTasksInterface = new UserTasksInterface();
        this.manageTaskInterface = new ManageTaskInterface();
        this.allProjectTasksInterface = new AllProjectTasksInterface();
        this.logHoursInterface = new LogHoursInterface();
        this.addSalaryInterface = new AddSalaryInterface();
        this.userSalaryInterface = new UserSalaryInterface();
        this.adminInterface = new AdminInterface();

        this.taskLibrary = new TaskLibrary();
        this.projectLibrary = new ProjectLibrary();
        this.userLibrary = new UserLibrary();
        this.roleLibrary = new RoleLibrary();
        this.sysAdminLibrary = new SysAdminLibrary();
        this.salaryLibrary = new SalaryLibrary();
        this.meetingLibrary = new MeetingLibrary();
        this.notificationLibrary = new NotificationLibrary();

        this.emailFunction = new Email();
    }

    public void setUser(User user){
        this.currentUser = user;
    }

    public User getUser(){
        return this.currentUser;
    }

    public void start(){
        this.scene.getStylesheets().add("css/styles.css");
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Import file");
        fileChooser.getExtensionFilters().addAll(
        new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        showMainMenu();
        File selectedFile = fileChooser.showOpenDialog(stage);
        if (selectedFile != null) {
        Import.importData(selectedFile.getAbsolutePath(),  userLibrary, roleLibrary,  taskLibrary, projectLibrary, meetingLibrary, salaryLibrary);
            System.out.println("Data loaded.");
        }
        testingInit();
    }

    private void changeScene(AnchorPane gui, String title){
        this.scene.setRoot(gui);
        this.stage.setTitle(title);
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    private void showMainMenu(){
        AnchorPane gui = mainMenuInterface.getGUI();
        String title = mainMenuInterface.getTitle();
        changeScene(gui, title);


        Button registerBtn = mainMenuInterface.getRegisterBtn();
        registerBtn.setOnAction(event -> showRegister());
        Button loginBtn = mainMenuInterface.getLoginBtn();
        loginBtn.setOnAction(event -> showLogin());
    }

    private void showLogin(){
        AnchorPane gui = loginInterface.getGUI();
        String title = loginInterface.getTitle();
        Hyperlink mainMenuLink = loginInterface.getMainMenuLink();
        mainMenuLink.setOnAction(event -> showMainMenu());
        Hyperlink registerLink = loginInterface.getRegisterLink();
        registerLink.setOnAction(event -> showRegister());

        Label debug = loginInterface.getDebug();
        TextField emailField = loginInterface.getUserEmail();
        PasswordField passwordField = loginInterface.getUserPassword();

        debug.setText("");
        emailField.setText("");
        passwordField.setText("");

        Button submitLoginBtn = loginInterface.getSubmitLoginBtn();
        submitLoginBtn.setOnAction(event -> {
            debug.setText("");
            String email = emailField.getText();
            String password = passwordField.getText();
            if(email.length() == 0 || password.length() == 0){
                debug.setText("Enter all fields");
            } else if(userLibrary.isRegistered(email,password)){
                User currentUser = userLibrary.getUser(email);
                setUser(currentUser);
                showUserMenu();
            } else if(sysAdminLibrary.isRegistered(email, password)){
                SysAdmin admin = (SysAdmin) sysAdminLibrary.getUser(email);
                setUser(admin);
                showAdmin();
            }else{
                debug.setText("Account not found.");
            }
        });

        changeScene(gui, title);
    }

    private void showRegister(){
        AnchorPane gui = registerInterface.getGUI();
        String title = registerInterface.getTitle();

        Hyperlink mainMenuLink = registerInterface.getMainMenuLink();
        mainMenuLink.setOnAction(event -> showMainMenu());
        Hyperlink loginLink = registerInterface.getLoginLink();
        loginLink.setOnAction(event -> showLogin());

        Button createAccBtn = registerInterface.getCreateAccBtn();
        Label debug = registerInterface.getDebug();
        TextField emailField = registerInterface.getUserEmail();
        TextField firstNameField = registerInterface.getUserFirstName();
        TextField lastNameField = registerInterface.getUserLastName();
        PasswordField passwordField = registerInterface.getUserPassword();
        PasswordField passwordConfirmField = registerInterface.getUserPasswordConfirm();

        debug.setText("");
        emailField.setText("");
        firstNameField.setText("");
        lastNameField.setText("");
        passwordField.setText("");
        passwordConfirmField.setText("");
        createAccBtn.setOnAction(event -> {
            debug.setText("");
            String email = emailField.getText();
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String password = passwordField.getText();
            String passwordConfirm = passwordConfirmField.getText();
            if(email.length() == 0 || firstName.length() == 0 || lastName.length() == 0 || password.length() == 0 || passwordConfirm.length() == 0){
                debug.setText("Enter all fields");
            } else if(userLibrary.isEmailRegistered(email)){
                debug.setText("Email is already in use. Log in instead.");
            } else if(!EmailValidation.isEmailValid(email)){
                debug.setText("Email is not valid");
            }else if(password.length() < 8){
                debug.setText("Password must be 8 or more characters");
            } else if(!password.equals(passwordConfirm)){
                debug.setText("Passwords do not match.");
            } else{
                User newUser = new User(email,firstName,lastName,password);
                userLibrary.addUser(newUser);
                Alert accCreatedAlert = new Alert(Alert.AlertType.INFORMATION);
                accCreatedAlert.headerTextProperty().set("Account successfully created!");
                accCreatedAlert.titleProperty().set("Confirmation");

                accCreatedAlert.showAndWait().ifPresent(response -> {
                    if (response == ButtonType.OK) {
                        showLogin();
                    }
                });
            }
        });
        changeScene(gui, title);
    }

    private void showUserMenu(){
        AnchorPane gui = userInterface.getGUI();
        String title = userInterface.getTitle();

        Button createAProjectBtn = userInterface.getCreateAProjectBtn();
        createAProjectBtn.setOnAction(event -> showCreateProjectMenu());

        Button closeAProject = userInterface.getCloseAProjectBtn();
        closeAProject.setOnAction(event -> showCloseProject());

        Button projectsBtn = userInterface.getProjectsBtn();
        projectsBtn.setOnAction(event -> showUserProjectsMenu());

        Button pastProjectsBtn = userInterface.getPastProjectsBtn();
        pastProjectsBtn.setOnAction(event -> showPastProjects());

        Button notificationsBtn = userInterface.getNotificationsBtn();
        notificationsBtn.setOnAction(event -> showNotificationsMenu());

        Label userMenuLabel = userInterface.getUserMenuLabel();
        userMenuLabel.setText("Welcome, " + getUser().getNames());



        Hyperlink logoutLink = userInterface.getLogoutLink();
        logoutLink.setOnAction(event -> {
            setUser(null);
            showMainMenu();
        });
        changeScene(gui, title);
    }



    private void showCloseProject(){
        AnchorPane gui = closeProjectInterface.getGUI();
        String title = closeProjectInterface.getTitle();
        Hyperlink backToUserMenu = closeProjectInterface.getBackToUserMenuLink();
        ChoiceBox<String> projectsCb = closeProjectInterface.getProjectsCb();
        projectsCb.getItems().clear();
        Button closeProjectBtn = closeProjectInterface.getCloseProjectBtn();
        ArrayList<String> allProjects = roleLibrary.getScrumAndProductProjects(getUser());
        GridPane grid = (GridPane) gui.getChildren().get(2);

        ArrayList<Project> userProjects = (ArrayList<Project>) projectLibrary.getAllActiveProjects(allProjects).stream().distinct().collect(Collectors.toList());
        if(userProjects.size() == 0){
            GridTools.addLabelIfNoItems(userProjects.size(), grid, "You don't have any projects to close.");
            grid.getChildren().remove(projectsCb);
            grid.getChildren().remove(closeProjectBtn);
        } else{
            if (!grid.getChildren().contains(projectsCb) && !grid.getChildren().contains(closeProjectBtn)) {
                grid.getChildren().add(projectsCb);
                grid.getChildren().add(closeProjectBtn);
            }
        }

        projectsCb.setValue("Select a project:");


        for(int i = 0; i < userProjects.size(); i++) {
            Project currentProject = userProjects.get(i);
            projectsCb.getItems().add((i + 1) + ") " + currentProject.getProjectName());
        }

        closeProjectBtn.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                int index = Integer.parseInt(projectsCb.getValue().substring(0,1)) - 1;
                Project currentProject = userProjects.get(index);
                currentProject.setStatusClose();
                double totalCosts = salaryLibrary.getProjectTotalCost(currentProject.getProjectID());
                Alert accCreatedAlert = new Alert(Alert.AlertType.INFORMATION);
                accCreatedAlert.headerTextProperty().set("Total Costs: " + totalCosts);
                accCreatedAlert.titleProperty().set("Project Costs");

                accCreatedAlert.showAndWait().ifPresent(response -> {
                    if (response == ButtonType.OK) {
                        showUserMenu();
                    }
                });
            }
        });

        backToUserMenu.setOnAction(event -> showUserMenu());

        changeScene(gui, title);

    }

    private void showPastProjects(){
        AnchorPane gui = pastProjectsInterface.getGUI();
        String title = pastProjectsInterface.getTitle();
        Hyperlink backToUserMenu = pastProjectsInterface.getBackToUserMenuLink();

        backToUserMenu.setOnAction(event -> showUserMenu());

        GridPane grid = (GridPane) gui.getChildren().get(2);
        grid.getChildren().remove(0,grid.getChildren().size());
        ArrayList<String> allUserProjects = roleLibrary.getAllUserProjects(getUser());
        ArrayList<Project> userProjects = projectLibrary.getAllClosedProjects(allUserProjects);

        GridTools.addLabelIfNoItems(userProjects.size(),grid,"You don't have any past projects.");


        for(int i = 0; i < userProjects.size(); i++){
            VBox box = new VBox();
            box.getStyleClass().add("projects");
            Label projectName = new Label(userProjects.get(i).getProjectName());
            Label projectDesc = new Label(userProjects.get(i).getProjectDescription());
            box.getChildren().addAll(projectName,projectDesc);

            GridPane.setConstraints(box, 0, i);
            grid.getChildren().add(box);

        }

        changeScene(gui, title);

    }

    private void showNotificationsMenu() {
        AnchorPane gui = notificationInterface.getGUI();
        String title = notificationInterface.getTitle();
        Hyperlink backToUserMenu = notificationInterface.getBackToUserMenuLink();

        GridPane grid = (GridPane) gui.getChildren().get(2);
        grid.getChildren().remove(0,grid.getChildren().size());

        backToUserMenu.setOnAction(event -> showUserMenu());

        ArrayList<Notification> notifications = notificationLibrary.getAllNotificationsOfUser(getUser());
        GridTools.addLabelIfNoItems(notifications.size(),grid,"You don't have any nofications.");

        int i = 0;
        for (Notification currentNotification : notifications) {
            VBox box = new VBox();
            box.getStyleClass().add("notifications");
            Label notificationTitle  = new Label(currentNotification.getNotificationTitle());
            Label notificationBody  = new Label(currentNotification.getNotificationBody());
            box.getChildren().addAll(notificationTitle,notificationBody);
            Button delBtn = new Button("x");
            delBtn.getStyleClass().add("del-btn");

            GridPane.setConstraints(box, 0, i);
            grid.getChildren().add(box);
            GridPane.setConstraints(delBtn, 1, i);
            grid.getChildren().add(delBtn);
            i++;

            delBtn.setOnAction(new EventHandler() {
                @Override
                public void handle(Event event) {
                    int row = GridPane.getRowIndex(delBtn);
                    VBox box = GridTools.getVBoxAtRow(row, grid);
                    Notification notification = notificationLibrary.getNotificationFromID(currentNotification.getNotificationID());
                    notificationLibrary.deleteNotification(notification, getUser());
                    grid.getChildren().removeAll(box, delBtn);
                }
            });
        }
        changeScene(gui, title);
    }

    private void showCreateProjectMenu(){
        AnchorPane gui = createProjectInterface.getGUI();
        String title = createProjectInterface.getTitle();
        Hyperlink backToUserMenu = createProjectInterface.getBackToUserMenuLink();
        backToUserMenu.setOnAction(event -> showUserMenu());

        Button createProjectBtn = createProjectInterface.getCreateProjectBtn();
        Label debug = createProjectInterface.getDebug();

        TextField projectNameField = createProjectInterface.getProjectName();
        TextArea projectDescriptionField = createProjectInterface.getProjectDescription();

        createProjectBtn.setOnAction(event -> {
            debug.setText("");
            String projectNameText = projectNameField.getText();
            String projectDescriptionText = projectDescriptionField.getText();
            if(projectNameText.length() == 0){
                debug.setText("Please enter a project name");
            } else if(projectNameText.length() > 100){
                debug.setText("Project name must be 100 characters or less");
            } else if(projectDescriptionText.length() > 250){
                debug.setText("Project description must be 250 characters or less");
            } else{
                Project newProject = new Project(projectNameText, projectDescriptionText);
                projectLibrary.addProject(newProject);
                Role newRole = new Role(getUser(), newProject.getProjectID());
                newRole.setRoleProjectCreator();
                roleLibrary.addRole(newRole);
                projectNameField.setText("");
                projectDescriptionField.setText("");
                showUserMenu();
            }
        });

        changeScene(gui, title);
    }

    private void showUserProjectsMenu(){
        AnchorPane gui = userProjectsInterface.getGUI();
        String title = userProjectsInterface.getTitle();
        Hyperlink backToUserMenu = userProjectsInterface.getBackToUserMenuLink();

        backToUserMenu.setOnAction(event -> showUserMenu());

        GridPane grid = (GridPane) gui.getChildren().get(2);
        grid.getChildren().remove(0,grid.getChildren().size());
        ArrayList<String> allUserProjects = roleLibrary.getAllUserProjects(getUser());
        ArrayList<Project> userProjects = projectLibrary.getAllActiveProjects(allUserProjects);
        GridTools.addLabelIfNoItems(userProjects.size(),grid,"You don't have any projects.");

        for(int i = 0; i < userProjects.size(); i++){
            Button project = new Button(userProjects.get(i).getProjectName());
            int currentProject = i;
            project.setOnAction(event -> showManageProjectInterface(userProjects.get(currentProject)));
            GridPane.setConstraints(project, 0, i);
            grid.getChildren().add(project);
        }

        changeScene(gui, title);
    }


    private void showManageProjectInterface(Project project){
        AnchorPane gui = manageProjectInterface.getGUI();
        String title = manageProjectInterface.getTitle();

        Label projectName = manageProjectInterface.getProjectNameLabel();
        Label projectDesc = manageProjectInterface.getProjectDescLabel();

        projectName.setText(project.getProjectName());
        projectDesc.setText(project.getProjectDescription());

        Button addUserBtn = manageProjectInterface.getAddUserBtn();
        addUserBtn.setOnAction(event -> showAddUserInterface(project.getProjectID()));

        Button tasksBtn = manageProjectInterface.getTasksBtn();
        tasksBtn.setOnAction(event -> showTaskMenu(project.getProjectID()));

        Button createMeetingBtn = manageProjectInterface.getShowMeetingMenuBtn();
        createMeetingBtn.setOnAction((EventHandler) event -> {
            showUserMeetingInterface(project.getProjectID());
        });

        Button addSalaryBtn = manageProjectInterface.getAddSalaryBtn();
        addSalaryBtn.setOnAction(event -> showAddSalaryInterface(project.getProjectID()));


        Button currentSalariesBtn = manageProjectInterface.getCurrentSalariesBtn();
        currentSalariesBtn.setOnAction(event -> showUserSalaryInterface(project.getProjectID()));

        Role role = roleLibrary.getUserRoleInProject(project.getProjectID(), getUser());
        GridPane grid = (GridPane) gui.getChildren().get(1);

         if(!roleLibrary.doesScrumMasterExist(project.getProjectID()) && role.getRole().equals("Project Creator") || role.getRole().equals("Scrum Master")) {
             if (!grid.getChildren().contains(addUserBtn)) {
                 grid.getChildren().add(addUserBtn);
             }
         } else{
             grid.getChildren().remove(addUserBtn);
         }

         if(!roleLibrary.doesProductOwnerExist(project.getProjectID()) && role.getRole().equals("Project Creator") || role.getRole().equals("Product Owner")){
             if (!grid.getChildren().contains(addSalaryBtn)) {
                 grid.getChildren().add(addSalaryBtn);
             }
             if(!grid.getChildren().contains(currentSalariesBtn)){
                 grid.getChildren().add(currentSalariesBtn);
             }
         } else{
             grid.getChildren().remove(addSalaryBtn);
             grid.getChildren().remove(currentSalariesBtn);
         }

        if(!roleLibrary.doesProductOwnerOrScrumMasterExist(project.getProjectID()) && role.getRole().equals("Project Creator")  || role.getRole().equals("Product Owner") || role.getRole().equals("Scrum Master")){
            if(!grid.getChildren().contains(currentSalariesBtn)){
                grid.getChildren().add(currentSalariesBtn);
            }
        } else{
            grid.getChildren().remove(currentSalariesBtn);
        }


        Hyperlink link = manageProjectInterface.getBackToCurrentProjects();
        link.setOnAction(event -> showUserProjectsMenu());


        changeScene(gui, title);
    }

    private void showTaskMenu(String projectID){
        AnchorPane gui = taskMenuInterface.getGUI();
        String title = taskMenuInterface.getTitle();
        GridPane grid = (GridPane) gui.getChildren().get(2);

        Hyperlink link = taskMenuInterface.getBackToManageProject();
        link.setOnAction(event -> showManageProjectInterface(projectLibrary.getProject(projectID)));

        Button createATask = taskMenuInterface.getCreateTaskBtn();
        createATask.setOnAction(event -> showCreateTaskMenu(projectID));

        Button currentTasksBtn = taskMenuInterface.getCurrentTasksBtn();
        currentTasksBtn.setOnAction(event -> showUserTasksMenu(projectID));

        Button allTasksBtn = taskMenuInterface.getAllTasksBtn();
        allTasksBtn.setOnAction(event -> showAllProjectTasks(projectID));

        Button logHoursBtn = taskMenuInterface.getLogHoursBtn();
        logHoursBtn.setOnAction(event -> showLogHours(projectID));

        Role role = roleLibrary.getUserRoleInProject(projectID, getUser());

        if(!roleLibrary.doesScrumMasterExist(projectID) && role.getRole().equals("Project Creator") || role.getRole().equals("Scrum Master")) {
            if(!grid.getChildren().contains(allTasksBtn)){
                grid.getChildren().add(allTasksBtn);
            }
        } else{
            grid.getChildren().remove(allTasksBtn);
        }

        if(salaryLibrary.doesUserHaveASalary(getUser())) {
            if(!grid.getChildren().contains(logHoursBtn)){
                grid.getChildren().add(logHoursBtn);
            }
        } else{
            grid.getChildren().remove(logHoursBtn);
        }

        changeScene(gui, title);
    }


    private void showCreateTaskMenu(String ID){
        AnchorPane gui = createTaskInterface.getGUI();
        String title = createTaskInterface.getTitle();

        Hyperlink backToTaskMenu = createTaskInterface.getBackToTaskMenu();
        Button createTask = createTaskInterface.getCreateATaskBtn();
        TextField taskName = createTaskInterface.getTaskName();
        TextArea taskDesc = createTaskInterface.getTaskDesc();
        Label debug = createTaskInterface.getDebug();
        ChoiceBox<String> assignUserCB = createTaskInterface.getAssignUserCB();

        debug.setText("");

        backToTaskMenu.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                showTaskMenu(ID);
            }
        });

        ArrayList<User> allProjectUsers = roleLibrary.getAllProjectUsers(ID);

        GridPane grid = (GridPane) gui.getChildren().get(1);

        assignUserCB.getItems().clear();
        assignUserCB.setTooltip(new Tooltip("Assign task"));
        for(int j = 0; j < allProjectUsers.size(); j++){
            User user = allProjectUsers.get(j);
            assignUserCB.getItems().add(user.getEmail());
            if(user.equals(getUser())){
                assignUserCB.setValue(user.getEmail());
            }
        }

        Role role = roleLibrary.getUserRoleInProject(ID, getUser());
        if(!roleLibrary.doesScrumMasterExist(ID) && role.getRole().equals("Project Creator") || role.getRole().equals("Scrum Master")) {
            if (!grid.getChildren().contains(assignUserCB) && roleLibrary.getNumberOfUsersInProject(ID) > 1) {
                grid.getChildren().add(assignUserCB);
            }
        } else{
            grid.getChildren().remove(assignUserCB);
        }


        createTask.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                debug.setText("");
                String taskNameText = taskName.getText();
                String taskDescriptionText = taskDesc.getText();
                if(taskNameText.length() == 0){
                    debug.setText("Please enter a task name");
                }else if(taskNameText.length() > 100){
                    debug.setText("Task name must be 100 characters or less");
                } else if(taskDescriptionText.length() > 200){
                    debug.setText("Task description must be 200 characters or less");
                } else{
                    Task newTask = new Task(getUser(),ID, taskNameText, taskDescriptionText);
                    notificationLibrary.sendNewTaskNotification(roleLibrary.getAllProjectUsers(ID), newTask, projectLibrary.getProject(ID));

                    taskLibrary.addTask(newTask);
                    taskName.setText("");
                    taskDesc.setText("");
                    if(grid.getChildren().contains(assignUserCB)){
                        User assignUser = userLibrary.getUser(assignUserCB.getValue().toString());
                        newTask.setUserAssigned(assignUser);
                        notificationLibrary.sendTaskAssignedNotification(assignUser, newTask, projectLibrary.getProject(ID));
                    }
                    showTaskMenu(ID);
                }

            }
        });
        changeScene(gui, title);

    }

    private void showUserTasksMenu(String projectID){
        AnchorPane gui = userTasksInterface.getGUI();
        String title = userTasksInterface.getTitle();

        Hyperlink backToTaskMenu = userTasksInterface.getBackToTaskMenu();

        backToTaskMenu.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                showTaskMenu(projectID);
            }
        });

        GridPane grid = (GridPane) gui.getChildren().get(2);
        grid.getChildren().remove(0,grid.getChildren().size());

        ArrayList<Task> userTasks = taskLibrary.getAllUserTasks(getUser(),projectID);
        GridTools.addLabelIfNoItems(userTasks.size(),grid,"You don't have any tasks.");

        int startNum = 0;
        for(int i = 0; i < userTasks.size(); i++){
            Button taskBtn = new Button(userTasks.get(i).getTaskName());
            Task currentTask = userTasks.get(i);

            ChoiceBox<String> taskProgressCb = new ChoiceBox<>();
            taskProgressCb.getItems().addAll("Not started", "In progress", "Done");
            taskProgressCb.setValue(currentTask.getTaskProgress());
            Button delBtn = new Button("x");
            delBtn.getStyleClass().add("del-btn");


            taskProgressCb.setOnAction(new EventHandler(){
                @Override
                public void handle(Event event) {
                    String progress = taskProgressCb.getValue();
                    if(progress.equalsIgnoreCase("Not started")){
                        currentTask.setTaskNotStarted();
                    } else if(progress.equalsIgnoreCase("In progress")){
                        currentTask.setTaskInProgress();
                        notificationLibrary.sendNewProgressNotification(roleLibrary.getAllProjectUsers(projectID), currentTask, projectLibrary.getProject(projectID));
                    } else if(progress.equalsIgnoreCase("Done")){
                        currentTask.setTaskDone();
                        notificationLibrary.sendNewProgressNotification(roleLibrary.getAllProjectUsers(projectID), currentTask, projectLibrary.getProject(projectID));
                    }
                }
            });

            delBtn.setOnAction(new EventHandler(){
                @Override
                public void handle(Event event) {
                    int row = GridPane.getRowIndex(delBtn);
                    Button btn = GridTools.getButtonAtRow(row, grid);
                    ChoiceBox<String> cb = GridTools.getCBAtRow(row,grid);
                    Task task = taskLibrary.getTaskFromID(currentTask.getTaskID());
                    taskLibrary.removeTask(task);
                    grid.getChildren().removeAll(btn,cb, delBtn);
                }
            });


            taskBtn.setOnAction(event -> showManageTask(currentTask));
            GridPane.setConstraints(taskBtn, 0, startNum);
            grid.getChildren().add(taskBtn);
            GridPane.setConstraints(taskProgressCb, 1, startNum);
            grid.getChildren().add(taskProgressCb);

            GridPane.setConstraints(delBtn, 2, startNum);
            grid.getChildren().add(delBtn);
            startNum++;
        }

        changeScene(gui, title);
    }


    private void showAllProjectTasks(String ID){
        AnchorPane gui = allProjectTasksInterface.getGUI();
        String title = allProjectTasksInterface.getTitle();

        GridPane grid = (GridPane) gui.getChildren().get(2);
        grid.getChildren().remove(0,grid.getChildren().size());

        Hyperlink backToTaskMenu = allProjectTasksInterface.getBackToTaskMenu();
        backToTaskMenu.setOnAction(event -> showTaskMenu(ID));

        ArrayList<Task> allProjectTasks = taskLibrary.getAllProjectTasks(ID);
        ArrayList<User> allProjectUsers = roleLibrary.getAllProjectUsers(ID);
        GridTools.addLabelIfNoItems(allProjectTasks.size(),grid,"This project doesn't have any tasks.");


        for(int i = 0; i < allProjectTasks.size(); i++){
            Task currentTask = allProjectTasks.get(i);
            Button taskBtn = new Button(currentTask.getTaskName());
            Button delBtn = new Button("x");
            delBtn.getStyleClass().add("del-btn");

            delBtn.setOnAction(new EventHandler(){
                @Override
                public void handle(Event event) {
                    int row = GridPane.getRowIndex(delBtn);
                    Button btn = GridTools.getButtonAtRow(row, grid);
                    ChoiceBox<String> cb = GridTools.getCBAtRow(row,grid);
                    Task task = taskLibrary.getTaskFromID(currentTask.getTaskID());
                    taskLibrary.removeTask(task);
                    grid.getChildren().removeAll(btn,cb, delBtn);
                }
            });

            taskBtn.setOnAction(event -> showManageTask(currentTask));
            User userAssigned = currentTask.getUserAssigned();

            ChoiceBox<String> userAssignedCb = new ChoiceBox<>();
            userAssignedCb.setTooltip(new Tooltip("Reassign task"));
            for(int j = 0; j < allProjectUsers.size(); j++){
                User user = allProjectUsers.get(j);
                userAssignedCb.getItems().add(user.getEmail());
                if(user.equals(userAssigned)){
                    userAssignedCb.setValue(user.getEmail());
                }
            }

            userAssignedCb.setOnAction(new EventHandler(){
                @Override
                public void handle(Event event) {
                    int row = GridPane.getRowIndex(userAssignedCb);
                    Button btn = GridTools.getButtonAtRow(row, grid);

                    Task task = currentTask;
                    String userEmail = userAssignedCb.getValue().toString();
                    User user = userLibrary.getUser(userEmail);
                    task.setUserAssigned(user);
                    notificationLibrary.sendTaskAssignedNotification(user, task, projectLibrary.getProject(ID));
                }
            });

            GridPane.setConstraints(taskBtn, 0, i);
            grid.getChildren().add(taskBtn);

            GridPane.setConstraints(userAssignedCb, 1, i);
            grid.getChildren().add(userAssignedCb);

            GridPane.setConstraints(delBtn, 2, i);
            grid.getChildren().add(delBtn);
        }
        changeScene(gui, title);
    }

    private void showManageTask(Task task){
        AnchorPane gui = manageTaskInterface.getGUI();
        String title = manageTaskInterface.getTitle();
        Hyperlink backToCurrentTasks = manageTaskInterface.getBackToCurrentTasks();

        Label taskNameLabel = manageTaskInterface.getTaskNameLabel();
        Label taskDescLabel = manageTaskInterface.getTaskDescLabel();
        Label taskProgressLabel = manageTaskInterface.getTaskProgressLabel();
        taskNameLabel.setText("Task name:" + task.getTaskName());
        taskDescLabel.setText("Task description: " + task.getTaskDescription());
        taskProgressLabel.setText("Progress: " + task.getTaskProgress());

        if(!task.getUserAssigned().equals(getUser())){
            backToCurrentTasks.setText("Back to View All Project Tasks");
        } else {
            backToCurrentTasks.setText("Back to Current Tasks");
        }

        backToCurrentTasks.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                String linkText = backToCurrentTasks.getText();
                if(linkText.equals("Back to View All Project Tasks")){
                    showAllProjectTasks(task.getProjectID());
                } else{
                    showUserTasksMenu(task.getProjectID());
                }
            }
        });
        changeScene(gui, title);
    }

    private void showLogHours(String projectID) {
        AnchorPane gui = logHoursInterface.getGUI();
        String title = logHoursInterface.getTitle();
        TextField hoursInput = logHoursInterface.getHoursInput();
        Button addHoursBtn = logHoursInterface.getAddHoursBtn();
        Label debug = logHoursInterface.getDebug();
        hoursInput.setText("");
        debug.setText("");

        addHoursBtn.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                debug.setText("");
                String hoursText = hoursInput.getText();
                Integer hours = 0;
                if(!hoursText.equals("")){
                    hours = Integer.parseInt(hoursText);
                    if(hours <= 0){
                        debug.setText("Hours must be greater than 0");
                    } else{
                        Salary salary = salaryLibrary.getUserSalaryInProject(projectID, getUser());
                        salary.addHoursLogged(hours);
                        showTaskMenu(projectID);
                    }
                } else{
                    debug.setText("Enter hours");
                }
            }
        });

        Hyperlink backToTaskMenu = logHoursInterface.getBackToTaskMenu();
        backToTaskMenu.setOnAction((EventHandler) event -> {
            showTaskMenu(projectID);
        });

        changeScene(gui, title);
    }



        private void showUserMeetingInterface(String projectID) {
        AnchorPane gui = userMeetingInterface.getGUI();
        String title = userMeetingInterface.getTitle();

        Hyperlink backToManageProject = userMeetingInterface.getBackToManageProject();
        backToManageProject.setOnAction((EventHandler) event -> {
            showManageProjectInterface(projectLibrary.getProject(projectID));
        });
        Button createNewMeetingBtn = userMeetingInterface.getCreateNewMeetingBtn();
        createNewMeetingBtn.setOnAction((EventHandler) event -> {
            showCreateMeetingInterface(projectID);
        });

        Button meetingScheduleBtn = userMeetingInterface.getMeetingScheduleBtn();
            meetingScheduleBtn.setOnAction((EventHandler) event -> {
                showMeetingSchedule(projectID);
            });

            Button pastMeetingsBtn = userMeetingInterface.getPastMeetingsBtn();
            pastMeetingsBtn.setOnAction((EventHandler) event -> {
                showPastMeetings(projectID);
            });
        changeScene(gui, title);
    }


    private void showCreateMeetingInterface(String projectID) {
        AnchorPane gui = createMeetingInterface.getGUI();
        String title = createMeetingInterface.getTitle();

        Hyperlink backToMeetingMenu = createMeetingInterface.getBackToMeetingMenu();
        backToMeetingMenu.setOnAction((EventHandler) event -> {
            showUserMeetingInterface(projectID);
        });

        Label debugLabel = createMeetingInterface.getDebug();
        TextField locationField = createMeetingInterface.getMeetingLocation();
        locationField.setText("");
        DatePicker dateField = createMeetingInterface.getMeetingDate();
        dateField.setValue(null);
        debugLabel.setText("");

        Button createNewMeetingBtn = createMeetingInterface.getCreateNewMeetingInviteBtn();

        createNewMeetingBtn.setOnAction((EventHandler) event -> {
            debugLabel.setText("");
            String location = locationField.getText();
            LocalDate date = dateField.getValue();
            if(location.equals("")){
                debugLabel.setText("Enter a location");
            } else if(date == null){
                debugLabel.setText("Enter a date");
            }else{
                showUserMeetingInterface(projectID);
                String emailBody = "Team meeting was scheduled for project (" + projectLibrary.getProject(projectID).getProjectName() + "). \r Meeting location: " + location + " \n \n Sent by: " + getUser().getFirstName() + " " + getUser().getLastName() + ". Using Miss Management." ;
                emailFunction.sendFromGMail(emailFunction.getEmailLogin(), emailFunction.getEmailPassword(), roleLibrary.getAllUserEmails(projectID), "Team meeting scheduled - " + createMeetingInterface.getMeetingDate().getValue(), emailBody);
                Meeting meeting = new Meeting(projectID,getUser(), location, date);
                meetingLibrary.addMeeting(meeting);
                notificationLibrary.sendMeetingNotification(roleLibrary.getAllProjectUsers(projectID), projectLibrary.getProject(projectID));
            }

        });

        createMeetingInterface.getMeetingDate().setDayCellFactory(picker -> new DateCell() {
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                LocalDate today = LocalDate.now();
                setDisable(empty || date.compareTo(today) < 0 );
            }


        });
        changeScene(gui, title);
    }

    private void showMeetingSchedule(String projectID){
        AnchorPane gui = meetingScheduleInterface.getGUI();
        String title = meetingScheduleInterface.getTitle();
        Hyperlink backToMeetingMenu = meetingScheduleInterface.getBackToMeetingMenu();
        backToMeetingMenu.setOnAction((EventHandler) event -> {
            showUserMeetingInterface(projectID);
        });

        GridPane grid = (GridPane) gui.getChildren().get(2);
        grid.getChildren().remove(0,grid.getChildren().size());
        ArrayList<Meeting> upcomingMeetings = meetingLibrary.getUpcomingMeetings(projectID);

        GridTools.addLabelIfNoItems(upcomingMeetings.size(),grid,"You don't have any upcoming meetings.");


        for(int i = 0; i < upcomingMeetings.size(); i++){
            VBox box = new VBox();
            box.getStyleClass().add("meetings");
            Meeting meeting = upcomingMeetings.get(i);
            Label meetingCreator = new Label("Meeting created by: " + meeting.getMeetingCreator().getFirstName() + " " +meeting.getMeetingCreator().getLastName() );
            Label meetingLocation = new Label("Location: " + meeting.getLocation());
            Label meetingDate = new Label("Date: " + meeting.getMeetingDate());
            box.getChildren().addAll(meetingCreator,meetingLocation,meetingDate);

            GridPane.setConstraints(box, 0, i);
            grid.getChildren().add(box);

        }

        changeScene(gui, title);

    }

    private void showPastMeetings(String projectID){
        AnchorPane gui = pastMeetingsInterface.getGUI();
        String title = pastMeetingsInterface.getTitle();
        Hyperlink backToMeetingMenu = pastMeetingsInterface.getBackToMeetingMenu();
        backToMeetingMenu.setOnAction((EventHandler) event -> {
            showUserMeetingInterface(projectID);
        });

        GridPane grid = (GridPane) gui.getChildren().get(2);
        grid.getChildren().remove(0,grid.getChildren().size());
        ArrayList<Meeting> pastMeetings = meetingLibrary.getPastMeetings(projectID);

        GridTools.addLabelIfNoItems(pastMeetings.size(),grid,"You don't have any past meetings.");


        for(int i = 0; i < pastMeetings.size(); i++){
            VBox box = new VBox();
            box.getStyleClass().add("meetings");
            Meeting meeting = pastMeetings.get(i);
            Label meetingCreator = new Label("Meeting created by: " + meeting.getMeetingCreator().getFirstName() + " " +meeting.getMeetingCreator().getLastName() );
            Label meetingLocation = new Label("Location: " + meeting.getLocation());
            Label meetingDate = new Label("Date: " + meeting.getMeetingDate());
            box.getChildren().addAll(meetingCreator,meetingLocation,meetingDate);

            GridPane.setConstraints(box, 0, i);
            grid.getChildren().add(box);

        }

        changeScene(gui, title);

    }



    private void showAddUserInterface(String ID){
        AnchorPane gui = addUserInterface.getGUI();
        String title = addUserInterface.getTitle();
        Label debug = addUserInterface.getDebug();
        ChoiceBox<String> userRolesCb = addUserInterface.getUserRolesCb();
        Button addUserBtn = addUserInterface.getAddUserConfirmBtn();
        TextField email = addUserInterface.getUserEmail();

        debug.setText("");
        email.setText("");


        addUserBtn.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                String emailText = email.getText();
                String role = userRolesCb.getValue();

                if(emailText.equals("")){
                    debug.setText("Enter email address!");
                } else if(!EmailValidation.isEmailValid(emailText)){
                    debug.setText("Enter a valid email!");
                } else if(!userLibrary.isEmailRegistered(emailText)){
                    debug.setText("Account not found.");
                } else if(roleLibrary.isUserInProject(ID, emailText)){
                    debug.setText("User is already in project.");
                } else if(role.equals("Scrum Master")){
                    if(roleLibrary.doesScrumMasterExist(ID)){
                        debug.setText("Role is already filled.");
                    } else{
                        User user = userLibrary.getUser(emailText);
                        notificationLibrary.sendNewUserNotification(roleLibrary.getAllProjectUsers(ID), user, projectLibrary.getProject(ID));
                        Role newRole = new Role(user,ID);
                        roleLibrary.addRole(newRole);
                        newRole.setRoleScrumMaster();
                        notificationLibrary.sendProjectAddedNotification(user,projectLibrary.getProject(ID),newRole);
                        showManageProjectInterface(projectLibrary.getProject(ID));
                    }
                } else if(role.equals("Product Owner")){
                    if(roleLibrary.doesProductOwnerExist(ID)){
                        debug.setText("Role is already filled.");
                    } else{
                        User user = userLibrary.getUser(emailText);
                        notificationLibrary.sendNewUserNotification(roleLibrary.getAllProjectUsers(ID), user, projectLibrary.getProject(ID));
                        Role newRole = new Role(user,ID);
                        roleLibrary.addRole(newRole);
                        newRole.setRoleProductOwner();
                        notificationLibrary.sendProjectAddedNotification(user,projectLibrary.getProject(ID),newRole);
                        showManageProjectInterface(projectLibrary.getProject(ID));
                    }
                }else{
                    User user = userLibrary.getUser(emailText);
                    notificationLibrary.sendNewUserNotification(roleLibrary.getAllProjectUsers(ID), user, projectLibrary.getProject(ID));
                    Role newRole = new Role(user,ID);
                    roleLibrary.addRole(newRole);
                    newRole.setRoleDeveloper();
                    notificationLibrary.sendProjectAddedNotification(user,projectLibrary.getProject(ID),newRole);
                    showManageProjectInterface(projectLibrary.getProject(ID));
                }
            }
        });


        Hyperlink backToManageProject = addUserInterface.getBackToManageProject();
        backToManageProject.setOnAction(event -> showManageProjectInterface(projectLibrary.getProject(ID)));
        changeScene(gui, title);
    }



    private void showAddSalaryInterface(String ID){
        AnchorPane gui = addSalaryInterface.getGUI();
        String title = addSalaryInterface.getTitle();

        Hyperlink backToManageProject = addSalaryInterface.getBackToManageProject();
        Button addSalary = addSalaryInterface.getAddSalaryBtn();
        TextField hourSalaryField = addSalaryInterface.getHourSalary();
        Label debug = addSalaryInterface.getDebug();

        ChoiceBox<String> allUsersCB = addSalaryInterface.getAllUsersCB();
        allUsersCB.getItems().clear();
        ArrayList<User> allProjectUsers = roleLibrary.getAllProjectUsers(ID);
        allUsersCB.setTooltip(new Tooltip("Select user"));
        for(int j = 0; j < allProjectUsers.size(); j++){
            User user = allProjectUsers.get(j);
            allUsersCB.getItems().add(user.getEmail());
            if(user.equals(getUser())){
                allUsersCB.setValue(user.getEmail());
            }
        }
        debug.setText("");

        backToManageProject.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                showManageProjectInterface(projectLibrary.getProject(ID));
            }
        });

        addSalary.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                debug.setText("");
                String emailText = allUsersCB.getValue().toString();
                Double hourSalary = 0.0;
                if(!hourSalaryField.getText().equals("")){
                    hourSalary = Double.parseDouble(hourSalaryField.getText());
                    if(salaryLibrary.doesUserHaveSalaryInProject(emailText,ID)) {
                        debug.setText("User already has a salary.");
                    }else if (hourSalary <= 0) {
                        debug.setText("Salary can not be 0 or less than zero");
                    } else {
                        Salary salary = new Salary(userLibrary.getUser(emailText), hourSalary,0, ID);
                        salaryLibrary.addSalary(salary);
                        hourSalaryField.setText("");
                        showManageProjectInterface(projectLibrary.getProject(ID));
                    }
                } else{
                    debug.setText("Enter a salary");
                }
            }
        });
        changeScene(gui, title);

    }
    private void showUserSalaryInterface(String projectID) {
        AnchorPane gui = userSalaryInterface.getGUI();
        String title = userSalaryInterface.getTitle();


        GridPane grid = (GridPane) gui.getChildren().get(2);
        grid.getChildren().remove(0,grid.getChildren().size());


        Hyperlink backToManageProjects = userSalaryInterface.getBackToManageProject();

        ObservableList<Salary> userSalaries = salaryLibrary.getTableData(projectID);
        TableView table = new TableView();
        TableColumn firstNameCol = new TableColumn("First Name");
        TableColumn lastNameCol = new TableColumn("Last Name");
        TableColumn emailCol = new TableColumn("Email");
        TableColumn salaryCol = new TableColumn("Salary(SEK)");
        TableColumn hoursLoggedCol = new TableColumn("Hours Logged");
        TableColumn totalCostsCol = new TableColumn("Total Costs");

        table.getColumns().addAll(firstNameCol, lastNameCol,emailCol, salaryCol,hoursLoggedCol, totalCostsCol);
        table.setItems(userSalaries);
        table.setMinWidth(600);
        firstNameCol.setPrefWidth(100);
        lastNameCol.setPrefWidth(100);
        salaryCol.setPrefWidth(100);
        emailCol.setPrefWidth(100);
        hoursLoggedCol.setPrefWidth(100);
        totalCostsCol.setPrefWidth(100);

        firstNameCol.setCellValueFactory(new PropertyValueFactory("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory("lastName"));
        emailCol.setCellValueFactory(new PropertyValueFactory("email"));
        salaryCol.setCellValueFactory(new PropertyValueFactory("salary"));
        hoursLoggedCol.setCellValueFactory(new PropertyValueFactory("hoursLogged"));
        totalCostsCol.setCellValueFactory(new PropertyValueFactory("totalCosts"));

        table.getColumns().setAll(firstNameCol, lastNameCol,emailCol, salaryCol,hoursLoggedCol,totalCostsCol);
        GridPane.setConstraints(table, 0, 0);
        grid.getChildren().add(table);

        backToManageProjects.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                showManageProjectInterface(projectLibrary.getProject(projectID));
            }
        });
        changeScene(gui, title);
    }



    private void showAdmin(){
        AnchorPane gui = adminInterface.getGUI();
        String title = adminInterface.getTitle();

        Button userExportBtn = adminInterface.getUserExportBtn();
        Hyperlink logoutLink = adminInterface.getLogoutLink();

        StringBuilder builder = new StringBuilder();
        builder.append(userLibrary.exportUserData());
        builder.append(projectLibrary.exportProjectData());
        builder.append(roleLibrary.exportRoleData(projectLibrary));
        builder.append(taskLibrary.exportTaskData(projectLibrary));
        builder.append(meetingLibrary.exportMeetingData(projectLibrary));
        builder.append(salaryLibrary.exportSalaryData(projectLibrary));

        userExportBtn.setOnAction(event -> Export.createUserDataExport(builder.toString()));

        logoutLink.setOnAction(event -> {
            setUser(null);
            showMainMenu();
        });

        changeScene(gui, title);
    }




    public void testingInit(){
        sysAdminLibrary.addSysAdmin("admin@admin.com", "admin","admin","admin");
    }



}
