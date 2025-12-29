#### Table of Contents
1. [Introduction](#introduction)
2. [Prepare Your Development Environment](#prepare-your-development-environment)
     - [Installing Git, Node.js, and Docker](#installing-git-nodejs-and-docker)


## Introduction

These courses will provide you with all the fundamentals you need. 
To get the most out of this course, make sure you know JavaScript including 
* variables,
* functions and
* callbacks.

You'll also need to be familiar with the ES6 syntax, like 
* classes,
* error functions,
* spread syntax, and
* objective structuring since they'll popup throughout the videos.

Plus, understanding __promises__ and __async__ await is important. 
When it comes to Node.js, you should know how to install modules using npm and 
how to start an application. 
You also need a good handle on __Express__ and how __HTTP__ works. 
It will be super helpful if you have a basic understanding of __REST__ and __REST APIs__.

--



## Prepare Your Development Environment

### Installing Git, Node.js, and Docker
setting up your development environment. See it, like a checklist to make sure you won't get stuck later. 
So first of all, of course, we need 
1. Node.js - recommend installing the current LTS, means long-term supported version that you see here on the nodejs.org website.
2. Git - Then you will also need a Git client on your system to acquire the exercise files from GitHub. And you see when you go to git-scm.com that you will be presented with selections for your particular operating system.
3. Docker - As we will also use MongoDB and Redis and we will use Docker to run them. You will need to have Docker installed on your system. Here again, go to the respective website, this is docker.com and download the respective installation files for your system. Once you have installed all of that on your system, you can check it in your console or terminal by running `node -v`, `docker -v`, and `git -v`. Maybe the versions you see are different, but if the output looks somewhat like this, you are all set.

## Getting the exercise files from GitHub
To download all the files to get started, you have to clone this Git repository and 
I will show you now how you can fetch all the branches. 
So I'm now in my system terminal and there in the desktop folder, you can choose freely where on your system you want the exercise files to live. 
I will now create new folder node-microservices and then I will change into this folder. 
Cloning a repository with all its branches is not as easy as one might think. 

First you have to type `git clone --bare` and now I'm pasting in the github URL: git@github.com:LinkedInLearning/nodejs-microservices-4403064.git 
and then I add blank end .git So that's important. It has to end on blank .git, 
`git clone --bare git@github.com:LinkedInLearning/nodejs-microservices-4403064.git .git`
and then I hit Return. 
let's break down the command git clone --bare git@github.com:LinkedInLearning/nodejs-microservices-4403064.git .git:
* `git clone --bare`: This command creates a bare repository. A bare repository does not have a working directory and is typically used as a remote repository for sharing.
* `git@github.com:LinkedInLearning/nodejs-microservices-4403064.git`: This is the URL of the Git repository you want to clone.
* `.git`: This specifies the directory where the bare repository will be created. In this case, it's named .git.
So, this command clones the specified Git repository as a bare repository into a directory named `.git` on your local machine.

Next I type `git config --bool core.bare false`. If this all looks rather akin to you, don't worry for me as well, but this is how it's done. 
The command `git config --bool core.bare false` sets the core.bare configuration option to false for your Git repository. 
This means the repository is no longer treated as a bare repository and will have a working directory. 
Essentially, it converts a bare repository into a standard repository with a working directory where you can edit files.

Next I type `git reset --hard` and then I type `git branch`. Now you see it's a lot of branches are coming down and that's it. 
The command `git reset --hard` is used in Git to reset your current branch to a specific state, discarding all changes in the working directory and staging area. This means that any uncommitted changes will be lost, and the branch will be set to the last commit or a specified commit. It's a powerful command that should be used with caution, as it can lead to loss of work if not used properly.
The command `git branch` is used in Git to manage branches within a repository. It allows you to create, list, rename, and delete branches. Branches are essential for developing features or fixing bugs in isolation from the main codebase, enabling multiple developers to work on different tasks simultaneously without interfering with each other's work.

Now we have downloaded all the branches of all the exercise files. I will show you later how to switch between these branches but this is way easier in Visual Studio Code.

--








