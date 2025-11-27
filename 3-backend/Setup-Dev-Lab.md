**Programmers** specify the dependencies
**Spring** creates an application per your requirements.


setting up the development environment 
1. downloading and installing the Java Development Kit, or JDK, from the Oracle website, or using OpenJDK.
   1. Download JDK from [Spring Quickstart Guide](https://spring.io/quickstart) recommended JDK [https://bell-sw.com/pages/downloads/](BellSoft Liberica JDK 17 or 21)
   2. macOS > ARM > Standard JDK > Click DMG (follow the instructions)
   3. ```shell
      java -version
      openjdk version "21.0.9" 2025-10-21 LTS
      OpenJDK Runtime Environment (build 21.0.9+11-LTS)
      OpenJDK 64-Bit Server VM (build 21.0.9+11-LTS, mixed mode, sharing)
      ```
3. Next, download and install Maven from the Apache Maven website.
   1. [Download Apache Maven](https://maven.apache.org/download.cgi) click the 1st link: apache-maven-3.9.11-bin.tar.gz
   2. You should place the extracted apache-maven-3.9.11 folder in a standard location like `/usr/local/apache-maven` for installing third-party software on macOS. However If you want to install it only for your user, you can place it within/inside your home directory , for example, in `/Users/yourusername/`
   3. Extract the distribution archive in any directory. Use unzip apache-maven-3.9.11-bin.zip or tar xzvf apache-maven-3.9.11-bin.tar.gz depending on the archive.
   4. Add the bin directory of the created directory apache-maven-3.9.11 to the PATH environment variable
   5. Edit Shell Profile: Open your shell's profile file (e.g., ~/.bashrc, ~/.zshrc, or ~/.profile) in a text editor. Create/Edit a Configuration File. In most Unix-like environments (macOS, Linux), configuration files for the Zsh shell are typically named .zshrc and are located in your home directory (~)
      ```shell
      vi ~/.zshrc 
      export MAVEN_HOME=/usr/local/apache-maven/apache-maven-3.9.11
      export PATH=$MAVEN_HOME/bin:$PATH
      ```
   7. verify the signature of the release bundles, on the 1st checksums: apache-maven-3.9.11-bin.tar.gz.sha512  and compare it with
      ```shell
      shasum -a 512  /usr/local/apache-maven/apache-maven-3.9.11-bin.tar.gz 
      bcfe4fe305c962ace56ac7b5fc7a08b87d5abd8b7e89027ab251069faebee516b0ded8961445d6d91ec1985dfe30f8153268843c89aa392733d1a3ec956c9978  /usr/local/apache-maven/apache-maven-3.9.11-bin.tar.gz
      ```
    9. Confirm with mvn -v in a new shell. The result should look similar to:
       ```shell
       mvn -v
       Apache Maven 3.9.11 (3e54c93a704957b63ee3494413a2b544fd3d825b)
       Maven home: /usr/local/apache-maven/apache-maven-3.9.11
       Java version: 21.0.9, vendor: BellSoft, runtime: /Library/Java/JavaVirtualMachines/liberica-jdk-21.jdk/Contents/Home
       Default locale: en_CA, platform encoding: UTF-8
       OS name: "mac os x", version: "15.5", arch: "aarch64", family: "mac"
       ```

Create a Maven Project:
1. open the terminal or command prompt navigate to the project directory `~/Documents/Project-Workspace/L0gN3/3-backend/3.0-devlab`
2. Run the command provided `mvn archetype:generate -DgroupId=com.l0gn3 -DartifactId=`
