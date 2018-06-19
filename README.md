# ProjectScheduler

## Problem
1. Calculate calendar schedules for project plans.
2. Each project plan consists of tasks. Every task has a certain duration.
3. A task can depend on zero or more other tasks. If a task depends on some other tasks, it can only be started after these tasks are completed.
4. So, for a set of tasks (with durations and dependencies), the solution for the challenge should generate a schedule, i.e. assign Start and End Dates for every task.

## Technologies Used to Solve the Problem
The solution to the problem take advantage the features of **SpringBoot**. *Web* and *REST* were used for creating a rest-enabled web app. *JPA* from Spring ecosytem was also used for data persistency. And *H2* was used as in-memory database which is also fully-supported by Spring.

[Angular](https://angular.io/) was used to create the UI for the said web app.

## Setting Up
1. Ensure that the following are installed:
- JDK8
- Eclipse
- git
- nodejs
- Gradle
- Angular CLI (after installation of nodejs, run the following command in cmd prompt, *npm install -g @angular/cli*.
2. SSH Key - The project can be cloned using SSH. And an SSH key is needed to clone it.
- In git bash, execute *ssh-keygen -t rsa -b 4096 -C "<your.email@address.com>"* to generate SSH key.
- Copy the SSH key by executing *clip < ~/.ssh/id_rsa.pub"*
- Paste the SSH key in text file and send it to aaron.macandili.public@gmail.com so I can include it my GitHub.
3. Clone the project.

### Backend
1. Using git bash, go to root directory and run *./gradlew eclipse*. This will download all dependencies.
2. After installing, open your favorite IDE (i.e. Eclipse) and run as java application the *ProjectPlansSchedulerApplication.java* file.

### Frontend
1. Using git bash, go to <root-dir>/web/scheduler-web and run *npm install*. This will download all npm packages including Angular.
2. After installation, on the same path, run *ng serve -o*. This will open a page in a browser. This will serve as our UI for our backend.

## Using and Testing the Application
1. Click *Create Project* button to start. A form will be shown.
2. The form will provide the following fields:
  * Project Name
  * Project Start Date
  * Plans
    * Plan Name
    * Tasks
      * Task ID
      * Task Name
      * Task Duration (in hours)
      * Depends On - this is where we can put the comma-separated task IDs of this specific task depends on.
3. The Project may contain multiple plans, each plan may contain multiple tasks and each task may contain 0 or more dependencies from other tasks.
4. Click *Create Project* to generate the overall project schedule.

## Limitations and future improvements
1. No data input validations in-placed yet.
2. *View All Project* feature can be added to view and list all projects created.
