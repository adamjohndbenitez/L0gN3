**Programmers** specify the dependencies \
**Spring** creates an application per your requirements.


# Setting up the development environment 
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
---

# Create a Maven Project:
1. open the terminal or command prompt navigate to the project directory `~/Documents/Project-Workspace/L0gN3/3-backend/3.0-devlab`
2. Run the command provided to generate a new Maven project `mvn archetype:generate -DgroupId=com.l0gn3 -DartifactId=life-log-man -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false` - we can also refer to the official site [Maven Quickstart Archetype](https://maven.apache.org/archetypes/maven-archetype-quickstart/)
   ```shell
   % pwd
   /Users/aj/Documents/Project-Workspace/L0gN3/3-backend/3.0-devlab
   % mvn archetype:generate -DgroupId=com.l0gn3 -DartifactId=life-log-man -DarchetypeartifactId=maven-archetype-quickstart -DinteractiveMode=false
   aj@AJs-MacBook-Pro 3.0-devlab % mvn archetype:generate -DgroupId=com.l0gn3 -DartifactId=life-log-man -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
   [INFO] Scanning for projects...
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-clean-plugin/3.2.0/maven-clean-plugin-3.2.0.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-clean-plugin/3.2.0/maven-clean-plugin-3.2.0.pom (5.3 kB at 7.6 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-plugins/35/maven-plugins-35.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-plugins/35/maven-plugins-35.pom (9.9 kB at 56 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/maven-parent/35/maven-parent-35.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/maven-parent/35/maven-parent-35.pom (45 kB at 253 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/apache/25/apache-25.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/apache/25/apache-25.pom (21 kB at 110 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-clean-plugin/3.2.0/maven-clean-plugin-3.2.0.jar
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-clean-plugin/3.2.0/maven-clean-plugin-3.2.0.jar (36 kB at 435 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-install-plugin/3.1.2/maven-install-plugin-3.1.2.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-install-plugin/3.1.2/maven-install-plugin-3.1.2.pom (8.5 kB at 48 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-install-plugin/3.1.2/maven-install-plugin-3.1.2.jar
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-install-plugin/3.1.2/maven-install-plugin-3.1.2.jar (32 kB at 165 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-deploy-plugin/3.1.2/maven-deploy-plugin-3.1.2.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-deploy-plugin/3.1.2/maven-deploy-plugin-3.1.2.pom (9.6 kB at 152 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-deploy-plugin/3.1.2/maven-deploy-plugin-3.1.2.jar
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-deploy-plugin/3.1.2/maven-deploy-plugin-3.1.2.jar (40 kB at 215 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-antrun-plugin/3.1.0/maven-antrun-plugin-3.1.0.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-antrun-plugin/3.1.0/maven-antrun-plugin-3.1.0.pom (9.1 kB at 49 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-plugins/34/maven-plugins-34.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-plugins/34/maven-plugins-34.pom (11 kB at 59 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-antrun-plugin/3.1.0/maven-antrun-plugin-3.1.0.jar
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-antrun-plugin/3.1.0/maven-antrun-plugin-3.1.0.jar (41 kB at 223 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-assembly-plugin/3.7.1/maven-assembly-plugin-3.7.1.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-assembly-plugin/3.7.1/maven-assembly-plugin-3.7.1.pom (15 kB at 220 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-plugins/41/maven-plugins-41.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-plugins/41/maven-plugins-41.pom (7.4 kB at 102 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-assembly-plugin/3.7.1/maven-assembly-plugin-3.7.1.jar
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-assembly-plugin/3.7.1/maven-assembly-plugin-3.7.1.jar (240 kB at 623 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-dependency-plugin/3.7.0/maven-dependency-plugin-3.7.0.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-dependency-plugin/3.7.0/maven-dependency-plugin-3.7.0.pom (19 kB at 104 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-dependency-plugin/3.7.0/maven-dependency-plugin-3.7.0.jar
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-dependency-plugin/3.7.0/maven-dependency-plugin-3.7.0.jar (207 kB at 1.6 MB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-release-plugin/3.0.1/maven-release-plugin-3.0.1.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-release-plugin/3.0.1/maven-release-plugin-3.0.1.pom (9.8 kB at 151 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/release/maven-release/3.0.1/maven-release-3.0.1.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/release/maven-release/3.0.1/maven-release-3.0.1.pom (11 kB at 178 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-release-plugin/3.0.1/maven-release-plugin-3.0.1.jar
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-release-plugin/3.0.1/maven-release-plugin-3.0.1.jar (61 kB at 579 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/codehaus/mojo/maven-metadata.xml
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-metadata.xml
   Downloaded from central: https://repo.maven.apache.org/maven2/org/codehaus/mojo/maven-metadata.xml (21 kB at 152 kB/s)
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-metadata.xml (14 kB at 79 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-archetype-plugin/maven-metadata.xml
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-archetype-plugin/maven-metadata.xml (1.1 kB at 6.2 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-archetype-plugin/3.4.1/maven-archetype-plugin-3.4.1.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-archetype-plugin/3.4.1/maven-archetype-plugin-3.4.1.pom (11 kB at 59 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/archetype/maven-archetype/3.4.1/maven-archetype-3.4.1.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/archetype/maven-archetype/3.4.1/maven-archetype-3.4.1.pom (9.8 kB at 145 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/groovy/groovy-bom/4.0.28/groovy-bom-4.0.28.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/groovy/groovy-bom/4.0.28/groovy-bom-4.0.28.pom (27 kB at 151 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-archetype-plugin/3.4.1/maven-archetype-plugin-3.4.1.jar
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-archetype-plugin/3.4.1/maven-archetype-plugin-3.4.1.jar (100 kB at 385 kB/s)
   [INFO] 
   [INFO] ------------------< org.apache.maven:standalone-pom >-------------------
   [INFO] Building Maven Stub Project (No POM) 1
   [INFO] --------------------------------[ pom ]---------------------------------
   [INFO] 
   [INFO] >>> archetype:3.4.1:generate (default-cli) > generate-sources @ standalone-pom >>>
   [INFO] 
   [INFO] <<< archetype:3.4.1:generate (default-cli) < generate-sources @ standalone-pom <<<
   [INFO] 
   [INFO] 
   [INFO] --- archetype:3.4.1:generate (default-cli) @ standalone-pom ---
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/archetype/archetype-catalog/3.4.1/archetype-catalog-3.4.1.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/archetype/archetype-catalog/3.4.1/archetype-catalog-3.4.1.pom (1.7 kB at 10 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/archetype/archetype-models/3.4.1/archetype-models-3.4.1.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/archetype/archetype-models/3.4.1/archetype-models-3.4.1.pom (3.0 kB at 46 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/archetype/archetype-descriptor/3.4.1/archetype-descriptor-3.4.1.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/archetype/archetype-descriptor/3.4.1/archetype-descriptor-3.4.1.pom (1.9 kB at 11 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/archetype/archetype-common/3.4.1/archetype-common-3.4.1.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/archetype/archetype-common/3.4.1/archetype-common-3.4.1.pom (17 kB at 94 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/groovy/groovy/4.0.28/groovy-4.0.28.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/groovy/groovy/4.0.28/groovy-4.0.28.pom (24 kB at 287 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/groovy/groovy-json/4.0.28/groovy-json-4.0.28.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/groovy/groovy-json/4.0.28/groovy-json-4.0.28.pom (23 kB at 125 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/groovy/groovy-templates/4.0.28/groovy-templates-4.0.28.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/groovy/groovy-templates/4.0.28/groovy-templates-4.0.28.pom (23 kB at 316 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/groovy/groovy-xml/4.0.28/groovy-xml-4.0.28.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/groovy/groovy-xml/4.0.28/groovy-xml-4.0.28.pom (23 kB at 124 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/groovy/groovy-yaml/4.0.28/groovy-yaml-4.0.28.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/groovy/groovy-yaml/4.0.28/groovy-yaml-4.0.28.pom (23 kB at 129 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/com/fasterxml/jackson/dataformat/jackson-dataformat-yaml/2.19.2/jackson-dataformat-yaml-2.19.2.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/com/fasterxml/jackson/dataformat/jackson-dataformat-yaml/2.19.2/jackson-dataformat-yaml-2.19.2.pom (3.0 kB at 17 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/com/fasterxml/jackson/dataformat/jackson-dataformats-text/2.19.2/jackson-dataformats-text-2.19.2.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/com/fasterxml/jackson/dataformat/jackson-dataformats-text/2.19.2/jackson-dataformats-text-2.19.2.pom (3.5 kB at 20 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/ivy/ivy/2.5.3/ivy-2.5.3.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/ivy/ivy/2.5.3/ivy-2.5.3.pom (7.0 kB at 101 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-invoker/3.3.0/maven-invoker-3.3.0.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-invoker/3.3.0/maven-invoker-3.3.0.pom (4.2 kB at 24 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/commons-io/commons-io/2.20.0/commons-io-2.20.0.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/commons-io/commons-io/2.20.0/commons-io-2.20.0.pom (20 kB at 118 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/commons/commons-parent/85/commons-parent-85.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/commons/commons-parent/85/commons-parent-85.pom (78 kB at 1.1 MB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-velocity/2.2.1/plexus-velocity-2.2.1.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-velocity/2.2.1/plexus-velocity-2.2.1.pom (4.1 kB at 23 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/velocity/velocity-engine-core/2.4.1/velocity-engine-core-2.4.1.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/velocity/velocity-engine-core/2.4.1/velocity-engine-core-2.4.1.pom (12 kB at 196 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/velocity/velocity-engine-parent/2.4.1/velocity-engine-parent-2.4.1.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/velocity/velocity-engine-parent/2.4.1/velocity-engine-parent-2.4.1.pom (9.5 kB at 149 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/velocity/velocity-master/7/velocity-master-7.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/velocity/velocity-master/7/velocity-master-7.pom (7.9 kB at 44 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/commons/commons-lang3/3.19.0/commons-lang3-3.19.0.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/commons/commons-lang3/3.19.0/commons-lang3-3.19.0.pom (32 kB at 384 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/commons/commons-parent/88/commons-parent-88.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/commons/commons-parent/88/commons-parent-88.pom (80 kB at 1.1 MB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/junit/junit-bom/5.13.4/junit-bom-5.13.4.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/org/junit/junit-bom/5.13.4/junit-bom-5.13.4.pom (5.7 kB at 75 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/com/ibm/icu/icu4j/77.1/icu4j-77.1.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/com/ibm/icu/icu4j/77.1/icu4j-77.1.pom (1.5 kB at 7.1 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/maven-archiver/3.6.4/maven-archiver-3.6.4.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/maven-archiver/3.6.4/maven-archiver-3.6.4.pom (4.6 kB at 63 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-shared-components/45/maven-shared-components-45.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-shared-components/45/maven-shared-components-45.pom (3.8 kB at 39 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-archiver/4.10.0/plexus-archiver-4.10.0.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-archiver/4.10.0/plexus-archiver-4.10.0.pom (5.8 kB at 33 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-io/3.5.0/plexus-io-3.5.0.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-io/3.5.0/plexus-io-3.5.0.pom (4.3 kB at 54 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/io/airlift/aircompressor/0.27/aircompressor-0.27.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/io/airlift/aircompressor/0.27/aircompressor-0.27.pom (5.8 kB at 32 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/io/airlift/airbase/112/airbase-112.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/io/airlift/airbase/112/airbase-112.pom (69 kB at 849 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/junit/junit-bom/5.8.0-M1/junit-bom-5.8.0-M1.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/org/junit/junit-bom/5.8.0-M1/junit-bom-5.8.0-M1.pom (5.7 kB at 87 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/com/github/luben/zstd-jni/1.5.6-3/zstd-jni-1.5.6-3.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/com/github/luben/zstd-jni/1.5.6-3/zstd-jni-1.5.6-3.pom (2.0 kB at 11 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-interpolation/1.28/plexus-interpolation-1.28.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-interpolation/1.28/plexus-interpolation-1.28.pom (3.4 kB at 45 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-archiver/4.10.2/plexus-archiver-4.10.2.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-archiver/4.10.2/plexus-archiver-4.10.2.pom (7.0 kB at 39 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus/23/plexus-23.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus/23/plexus-23.pom (31 kB at 320 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-io/3.5.1/plexus-io-3.5.1.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-io/3.5.1/plexus-io-3.5.1.pom (4.3 kB at 25 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/commons/commons-compress/1.28.0/commons-compress-1.28.0.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/commons/commons-compress/1.28.0/commons-compress-1.28.0.pom (25 kB at 141 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/commons-codec/commons-codec/1.19.0/commons-codec-1.19.0.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/commons-codec/commons-codec/1.19.0/commons-codec-1.19.0.pom (18 kB at 265 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/tukaani/xz/1.10/xz-1.10.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/org/tukaani/xz/1.10/xz-1.10.pom (1.9 kB at 11 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/com/github/luben/zstd-jni/1.5.7-4/zstd-jni-1.5.7-4.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/com/github/luben/zstd-jni/1.5.7-4/zstd-jni-1.5.7-4.pom (2.0 kB at 11 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-interactivity-api/1.4/plexus-interactivity-api-1.4.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-interactivity-api/1.4/plexus-interactivity-api-1.4.pom (1.7 kB at 7.0 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-interactivity/1.4/plexus-interactivity-1.4.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-interactivity/1.4/plexus-interactivity-1.4.pom (1.7 kB at 22 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugin-tools/maven-plugin-annotations/3.15.1/maven-plugin-annotations-3.15.1.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugin-tools/maven-plugin-annotations/3.15.1/maven-plugin-annotations-3.15.1.pom (1.5 kB at 12 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugin-tools/maven-plugin-tools/3.15.1/maven-plugin-tools-3.15.1.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugin-tools/maven-plugin-tools/3.15.1/maven-plugin-tools-3.15.1.pom (18 kB at 232 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/junit/junit-bom/5.11.3/junit-bom-5.11.3.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/org/junit/junit-bom/5.11.3/junit-bom-5.11.3.pom (5.6 kB at 61 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-script-interpreter/1.5/maven-script-interpreter-1.5.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-script-interpreter/1.5/maven-script-interpreter-1.5.pom (4.6 kB at 45 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache-extras/beanshell/bsh/2.0b6/bsh-2.0b6.pom
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache-extras/beanshell/bsh/2.0b6/bsh-2.0b6.pom (5.0 kB at 45 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/archetype/archetype-catalog/3.4.1/archetype-catalog-3.4.1.jar
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/archetype/archetype-catalog/3.4.1/archetype-catalog-3.4.1.jar (19 kB at 72 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-xml/3.0.1/plexus-xml-3.0.1.jar
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/archetype/archetype-descriptor/3.4.1/archetype-descriptor-3.4.1.jar
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/archetype/archetype-common/3.4.1/archetype-common-3.4.1.jar
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/groovy/groovy/4.0.28/groovy-4.0.28.jar
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/groovy/groovy-json/4.0.28/groovy-json-4.0.28.jar
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/archetype/archetype-descriptor/3.4.1/archetype-descriptor-3.4.1.jar (24 kB at 147 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/groovy/groovy-templates/4.0.28/groovy-templates-4.0.28.jar
   Downloaded from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-xml/3.0.1/plexus-xml-3.0.1.jar (94 kB at 425 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/groovy/groovy-xml/4.0.28/groovy-xml-4.0.28.jar
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/groovy/groovy-templates/4.0.28/groovy-templates-4.0.28.jar (94 kB at 345 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/groovy/groovy-yaml/4.0.28/groovy-yaml-4.0.28.jar
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/groovy/groovy-yaml/4.0.28/groovy-yaml-4.0.28.jar (6.3 kB at 17 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/com/fasterxml/jackson/dataformat/jackson-dataformat-yaml/2.19.2/jackson-dataformat-yaml-2.19.2.jar
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/groovy/groovy-xml/4.0.28/groovy-xml-4.0.28.jar (216 kB at 595 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/ivy/ivy/2.5.3/ivy-2.5.3.jar
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/groovy/groovy-json/4.0.28/groovy-json-4.0.28.jar (132 kB at 279 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/jdom/jdom2/2.0.6.1/jdom2-2.0.6.1.jar
   Downloaded from central: https://repo.maven.apache.org/maven2/com/fasterxml/jackson/dataformat/jackson-dataformat-yaml/2.19.2/jackson-dataformat-yaml-2.19.2.jar (60 kB at 123 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/commons-io/commons-io/2.20.0/commons-io-2.20.0.jar
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/archetype/archetype-common/3.4.1/archetype-common-3.4.1.jar (175 kB at 262 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-velocity/2.2.1/plexus-velocity-2.2.1.jar
   Downloaded from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-velocity/2.2.1/plexus-velocity-2.2.1.jar (5.7 kB at 5.0 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/com/ibm/icu/icu4j/77.1/icu4j-77.1.jar
   Downloaded from central: https://repo.maven.apache.org/maven2/commons-io/commons-io/2.20.0/commons-io-2.20.0.jar (564 kB at 443 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/maven-archiver/3.6.4/maven-archiver-3.6.4.jar
   Downloaded from central: https://repo.maven.apache.org/maven2/org/jdom/jdom2/2.0.6.1/jdom2-2.0.6.1.jar (328 kB at 251 kB/s)
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/ivy/ivy/2.5.3/ivy-2.5.3.jar (1.4 MB at 1.1 MB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-interpolation/1.28/plexus-interpolation-1.28.jar
   Downloading from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-archiver/4.10.2/plexus-archiver-4.10.2.jar
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/maven-archiver/3.6.4/maven-archiver-3.6.4.jar (27 kB at 19 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/javax/inject/javax.inject/1/javax.inject-1.jar
   Downloaded from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-interpolation/1.28/plexus-interpolation-1.28.jar (87 kB at 62 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-io/3.5.1/plexus-io-3.5.1.jar
   Downloaded from central: https://repo.maven.apache.org/maven2/javax/inject/javax.inject/1/javax.inject-1.jar (2.5 kB at 1.7 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/commons/commons-compress/1.28.0/commons-compress-1.28.0.jar
   Downloaded from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-archiver/4.10.2/plexus-archiver-4.10.2.jar (230 kB at 155 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/commons-codec/commons-codec/1.19.0/commons-codec-1.19.0.jar
   Downloaded from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-io/3.5.1/plexus-io-3.5.1.jar (80 kB at 53 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/io/airlift/aircompressor/0.27/aircompressor-0.27.jar
   Downloaded from central: https://repo.maven.apache.org/maven2/io/airlift/aircompressor/0.27/aircompressor-0.27.jar (255 kB at 149 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/tukaani/xz/1.10/xz-1.10.jar
   Downloaded from central: https://repo.maven.apache.org/maven2/commons-codec/commons-codec/1.19.0/commons-codec-1.19.0.jar (375 kB at 213 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/com/github/luben/zstd-jni/1.5.7-4/zstd-jni-1.5.7-4.jar
   Downloaded from central: https://repo.maven.apache.org/maven2/org/tukaani/xz/1.10/xz-1.10.jar (169 kB at 82 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-utils/4.0.2/plexus-utils-4.0.2.jar
   Downloaded from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-utils/4.0.2/plexus-utils-4.0.2.jar (193 kB at 87 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-interactivity-api/1.4/plexus-interactivity-api-1.4.jar
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/commons/commons-compress/1.28.0/commons-compress-1.28.0.jar (1.1 MB at 491 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugin-tools/maven-plugin-annotations/3.15.1/maven-plugin-annotations-3.15.1.jar
   Downloaded from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-interactivity-api/1.4/plexus-interactivity-api-1.4.jar (10 kB at 4.5 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-shared-utils/3.4.2/maven-shared-utils-3.4.2.jar
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugin-tools/maven-plugin-annotations/3.15.1/maven-plugin-annotations-3.15.1.jar (14 kB at 5.8 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-invoker/3.3.0/maven-invoker-3.3.0.jar
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-shared-utils/3.4.2/maven-shared-utils-3.4.2.jar (151 kB at 62 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/commons/commons-lang3/3.19.0/commons-lang3-3.19.0.jar
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-invoker/3.3.0/maven-invoker-3.3.0.jar (34 kB at 13 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/velocity/velocity-engine-core/2.4.1/velocity-engine-core-2.4.1.jar
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/commons/commons-lang3/3.19.0/commons-lang3-3.19.0.jar (709 kB at 256 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/commons-collections/commons-collections/3.2.2/commons-collections-3.2.2.jar
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/velocity/velocity-engine-core/2.4.1/velocity-engine-core-2.4.1.jar (516 kB at 178 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-script-interpreter/1.5/maven-script-interpreter-1.5.jar
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-script-interpreter/1.5/maven-script-interpreter-1.5.jar (25 kB at 7.8 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache-extras/beanshell/bsh/2.0b6/bsh-2.0b6.jar
   Downloaded from central: https://repo.maven.apache.org/maven2/commons-collections/commons-collections/3.2.2/commons-collections-3.2.2.jar (588 kB at 179 kB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/slf4j/slf4j-api/1.7.36/slf4j-api-1.7.36.jar
   Downloaded from central: https://repo.maven.apache.org/maven2/org/slf4j/slf4j-api/1.7.36/slf4j-api-1.7.36.jar (41 kB at 12 kB/s)
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache-extras/beanshell/bsh/2.0b6/bsh-2.0b6.jar (389 kB at 112 kB/s)
   Downloaded from central: https://repo.maven.apache.org/maven2/com/ibm/icu/icu4j/77.1/icu4j-77.1.jar (15 MB at 2.8 MB/s)
   Downloaded from central: https://repo.maven.apache.org/maven2/com/github/luben/zstd-jni/1.5.7-4/zstd-jni-1.5.7-4.jar (7.4 MB at 1.3 MB/s)
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/groovy/groovy/4.0.28/groovy-4.0.28.jar (7.7 MB at 1.1 MB/s)
   [INFO] Generating project in Batch mode
   Downloading from central: https://repo.maven.apache.org/maven2/archetype-catalog.xml
   Downloaded from central: https://repo.maven.apache.org/maven2/archetype-catalog.xml (17 MB at 49 MB/s)
   Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/archetypes/maven-archetype-quickstart/1.0/maven-archetype-quickstart-1.0.jar
   Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/archetypes/maven-archetype-quickstart/1.0/maven-archetype-quickstart-1.0.jar (4.3 kB at 15 kB/s)
   [INFO] ----------------------------------------------------------------------------
   [INFO] Using following parameters for creating project from Old (1.x) Archetype: maven-archetype-quickstart:1.0
   [INFO] ----------------------------------------------------------------------------
   [INFO] Parameter: basedir, Value: /Users/aj/Documents/Project-Workspace/L0gN3/3-backend/3.0-devlab
   [INFO] Parameter: package, Value: com.l0gn3
   [INFO] Parameter: groupId, Value: com.l0gn3
   [INFO] Parameter: artifactId, Value: life-log-man
   [INFO] Parameter: packageName, Value: com.l0gn3
   [INFO] Parameter: version, Value: 1.0-SNAPSHOT
   [INFO] project created from Old (1.x) Archetype in dir: /Users/aj/Documents/Project-Workspace/L0gN3/3-backend/3.0-devlab/life-log-man
   [INFO] ------------------------------------------------------------------------
   [INFO] BUILD SUCCESS
   [INFO] ------------------------------------------------------------------------
   [INFO] Total time:  19.442 s
   [INFO] Finished at: 2025-11-27T16:24:07-05:00
   [INFO] ------------------------------------------------------------------------
   ```


# Project Strucuture: 
Maven project is created, it follows a standard structure that helps organize files. The project folder contains the src directory and the pom.xml file at the root level. 

```
project
|-- .mvn
|   |-- jvm.config
|   `-- maven.config
|-- pom.xml                      <--8- The pom.xml file is an important part of the Maven project. It defines project details, such as the group ID and artifact ID lists dependencies, and specifies build configuration. Understanding this structure helps in managing code, organizing files, and collaborating with others. Once the project structure is understood, the next step is to add the required dependencies. Open the pom.xml file and include the necessary Spring libraries. These dependencies provide essential features for building a Spring application.
`-- src                          <--1- The src directory is divided into main and test.
    |-- main                     <--2- The main folder contains the application's main source code and resources,
    |   |-- java                 <--4- Inside src/main/java, all Java source files are placed, including configuration classes, service components, and controllers for web applications.
    |   |   `-- $package
    |   |       `-- App.java
    |   `-- resources            <--5- The src/main/resources folder stores configuration files, static assets such as HTML, and CSS and templates for web applications.
    |       `-- $package
    `-- test                     <--3- while the test folder holds test-related files.
        |-- java                 <--6- The src/test/java folder is used for writing test cases, such as unit tests and integration tests, using testing frameworks such as JUnit. 
        |   `-- $package
        |        `-- AppTest.java
         `-- resources           <--7- The src/test/resources folder contains additional resources needed during testing, such as configuration files and mock data.
             `-- $package
```
The pom.xml that is generated is a fundamental part of Maven. It stands for Project Object Model and is an XML file that contains information about the project and configuration details used by Maven to build the project.
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.example</groupId>                 <!-- groupId - A unique identifier for the project (for example, org.example) -->
    <artifactId>firstIntelliJProject</artifactId>  <!-- artifactId - The name of the project (for example, firstIntelliJProj) -->
    <version>1.0-SNAPSHOT</version>                <!-- version - The version of the project (for example, 1.0.0). -->

</project>
```

# Add dependencies
Once the project structure is understood, the next step is to add the required dependencies. Open the pom.xml file and include the necessary Spring libraries. These dependencies provide essential features for building a Spring application.   
```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.l0gn3</groupId>
  <artifactId>life-log-man</artifactId>
  <packaging>jar</packaging>
  <version>1.0-SNAPSHOT</version>
  <name>life-log-man</name>
  <url>http://maven.apache.org</url>
  <dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>3.8.1</version>
      <scope>test</scope>
    </dependency>
      
      <!-- Spring Core -->
      <dependency>
          <groupId>org.springframework</groupId>
          <artifactId>spring-context</artifactId>
          <version>6.2.12</version>
      </dependency>
      <!-- Spring Web -->
      <dependency>
          <groupId>org.springframework</groupId>
          <artifactId>spring-webmvc</artifactId>
          <version>6.2.12</version>
      </dependency>
      <!-- Servlet API -->
      <dependency>
          <groupId>javax.servlet</groupId>
          <artifactId>javax.servlet-api</artifactId>
          <version>3.1.0</version>
      </dependency>

  </dependencies>
</project>

```

Then, run mvn clean install in your terminal to download the dependencies. 
```
aj@AJs-MacBook-Pro l0gn3 % cd /Users/aj/Documents/Project-Workspace/L0gN3/3-backend/3.0-devlab/life-log-man
aj@AJs-MacBook-Pro life-log-man % mvn clean install 
[INFO] Scanning for projects...
[INFO] 
[INFO] -----------------------< com.l0gn3:life-log-man >-----------------------
[INFO] Building life-log-man 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- clean:3.2.0:clean (default-clean) @ life-log-man ---
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-shared-utils/3.3.4/maven-shared-utils-3.3.4.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-shared-utils/3.3.4/maven-shared-utils-3.3.4.jar (153 kB at 409 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/commons-io/commons-io/2.6/commons-io-2.6.jar
Downloaded from central: https://repo.maven.apache.org/maven2/commons-io/commons-io/2.6/commons-io-2.6.jar (215 kB at 1.3 MB/s)
[INFO] 
[INFO] --- resources:3.3.1:resources (default-resources) @ life-log-man ---
Downloading from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-interpolation/1.26/plexus-interpolation-1.26.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-interpolation/1.26/plexus-interpolation-1.26.jar (85 kB at 880 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-utils/3.5.1/plexus-utils-3.5.1.jar
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-filtering/3.3.1/maven-filtering-3.3.1.jar
Downloading from central: https://repo.maven.apache.org/maven2/org/sonatype/plexus/plexus-build-api/0.0.7/plexus-build-api-0.0.7.jar
Downloading from central: https://repo.maven.apache.org/maven2/commons-io/commons-io/2.11.0/commons-io-2.11.0.jar
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/commons/commons-lang3/3.12.0/commons-lang3-3.12.0.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-utils/3.5.1/plexus-utils-3.5.1.jar (269 kB at 2.2 MB/s)
Downloaded from central: https://repo.maven.apache.org/maven2/org/sonatype/plexus/plexus-build-api/0.0.7/plexus-build-api-0.0.7.jar (8.5 kB at 44 kB/s)
Downloaded from central: https://repo.maven.apache.org/maven2/commons-io/commons-io/2.11.0/commons-io-2.11.0.jar (327 kB at 974 kB/s)
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-filtering/3.3.1/maven-filtering-3.3.1.jar (55 kB at 153 kB/s)
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/commons/commons-lang3/3.12.0/commons-lang3-3.12.0.jar (587 kB at 1.6 MB/s)
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /Users/aj/Documents/Project-Workspace/L0gN3/3-backend/3.0-devlab/life-log-man/src/main/resources
[INFO] 
[INFO] --- compiler:3.13.0:compile (default-compile) @ life-log-man ---
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-shared-incremental/1.1/maven-shared-incremental-1.1.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-shared-incremental/1.1/maven-shared-incremental-1.1.jar (14 kB at 161 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-java/1.2.0/plexus-java-1.2.0.jar
Downloading from central: https://repo.maven.apache.org/maven2/org/ow2/asm/asm/9.6/asm-9.6.jar
Downloading from central: https://repo.maven.apache.org/maven2/com/thoughtworks/qdox/qdox/2.0.3/qdox-2.0.3.jar
Downloading from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-compiler-api/2.15.0/plexus-compiler-api-2.15.0.jar
Downloading from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-compiler-manager/2.15.0/plexus-compiler-manager-2.15.0.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-java/1.2.0/plexus-java-1.2.0.jar (58 kB at 612 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-xml/3.0.0/plexus-xml-3.0.0.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-compiler-api/2.15.0/plexus-compiler-api-2.15.0.jar (29 kB at 222 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-compiler-javac/2.15.0/plexus-compiler-javac-2.15.0.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-compiler-manager/2.15.0/plexus-compiler-manager-2.15.0.jar (5.2 kB at 35 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-utils/4.0.0/plexus-utils-4.0.0.jar
Downloaded from central: https://repo.maven.apache.org/maven2/com/thoughtworks/qdox/qdox/2.0.3/qdox-2.0.3.jar (334 kB at 1.4 MB/s)
Downloaded from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-xml/3.0.0/plexus-xml-3.0.0.jar (93 kB at 396 kB/s)
Downloaded from central: https://repo.maven.apache.org/maven2/org/ow2/asm/asm/9.6/asm-9.6.jar (124 kB at 524 kB/s)
Downloaded from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-compiler-javac/2.15.0/plexus-compiler-javac-2.15.0.jar (26 kB at 109 kB/s)
Downloaded from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-utils/4.0.0/plexus-utils-4.0.0.jar (192 kB at 731 kB/s)
[INFO] Recompiling the module because of changed source code.
[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
[INFO] Compiling 2 source files with javac [debug target 1.8] to target/classes
[WARNING] bootstrap class path not set in conjunction with -source 8
[WARNING] source value 8 is obsolete and will be removed in a future release
[WARNING] target value 8 is obsolete and will be removed in a future release
[WARNING] To suppress warnings about obsolete options, use -Xlint:-options.
[INFO] 
[INFO] --- resources:3.3.1:testResources (default-testResources) @ life-log-man ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /Users/aj/Documents/Project-Workspace/L0gN3/3-backend/3.0-devlab/life-log-man/src/test/resources
[INFO] 
[INFO] --- compiler:3.13.0:testCompile (default-testCompile) @ life-log-man ---
[INFO] Recompiling the module because of changed dependency.
[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
[INFO] Compiling 1 source file with javac [debug target 1.8] to target/test-classes
[WARNING] bootstrap class path not set in conjunction with -source 8
[WARNING] source value 8 is obsolete and will be removed in a future release
[WARNING] target value 8 is obsolete and will be removed in a future release
[WARNING] To suppress warnings about obsolete options, use -Xlint:-options.
[INFO] 
[INFO] --- surefire:3.2.5:test (default-test) @ life-log-man ---
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/maven-surefire-common/3.2.5/maven-surefire-common-3.2.5.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/maven-surefire-common/3.2.5/maven-surefire-common-3.2.5.jar (308 kB at 993 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-api/3.2.5/surefire-api-3.2.5.jar
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-logger-api/3.2.5/surefire-logger-api-3.2.5.jar
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-extensions-api/3.2.5/surefire-extensions-api-3.2.5.jar
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-booter/3.2.5/surefire-booter-3.2.5.jar
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-extensions-spi/3.2.5/surefire-extensions-spi-3.2.5.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-logger-api/3.2.5/surefire-logger-api-3.2.5.jar (14 kB at 186 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/eclipse/aether/aether-util/1.0.0.v20140518/aether-util-1.0.0.v20140518.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-extensions-spi/3.2.5/surefire-extensions-spi-3.2.5.jar (8.2 kB at 110 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/eclipse/aether/aether-api/1.0.0.v20140518/aether-api-1.0.0.v20140518.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-booter/3.2.5/surefire-booter-3.2.5.jar (118 kB at 1.5 MB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-common-artifact-filters/3.1.1/maven-common-artifact-filters-3.1.1.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-extensions-api/3.2.5/surefire-extensions-api-3.2.5.jar (26 kB at 319 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/commons-io/commons-io/2.15.1/commons-io-2.15.1.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-api/3.2.5/surefire-api-3.2.5.jar (171 kB at 1.6 MB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-shared-utils/3.2.5/surefire-shared-utils-3.2.5.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-common-artifact-filters/3.1.1/maven-common-artifact-filters-3.1.1.jar (61 kB at 352 kB/s)
Downloaded from central: https://repo.maven.apache.org/maven2/org/eclipse/aether/aether-api/1.0.0.v20140518/aether-api-1.0.0.v20140518.jar (136 kB at 717 kB/s)
Downloaded from central: https://repo.maven.apache.org/maven2/org/eclipse/aether/aether-util/1.0.0.v20140518/aether-util-1.0.0.v20140518.jar (146 kB at 613 kB/s)
Downloaded from central: https://repo.maven.apache.org/maven2/commons-io/commons-io/2.15.1/commons-io-2.15.1.jar (501 kB at 1.5 MB/s)
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-shared-utils/3.2.5/surefire-shared-utils-3.2.5.jar (2.4 MB at 5.5 MB/s)
[INFO] Using auto detected provider org.apache.maven.surefire.junit.JUnit3Provider
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-junit3/3.2.5/surefire-junit3-3.2.5.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-junit3/3.2.5/surefire-junit3-3.2.5.pom (3.1 kB at 39 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-providers/3.2.5/surefire-providers-3.2.5.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-providers/3.2.5/surefire-providers-3.2.5.pom (2.6 kB at 19 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/common-junit3/3.2.5/common-junit3-3.2.5.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/common-junit3/3.2.5/common-junit3-3.2.5.pom (2.8 kB at 29 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/common-java5/3.2.5/common-java5-3.2.5.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/common-java5/3.2.5/common-java5-3.2.5.pom (2.8 kB at 32 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-junit3/3.2.5/surefire-junit3-3.2.5.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-junit3/3.2.5/surefire-junit3-3.2.5.jar (24 kB at 293 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/common-junit3/3.2.5/common-junit3-3.2.5.jar
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/common-java5/3.2.5/common-java5-3.2.5.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/common-java5/3.2.5/common-java5-3.2.5.jar (18 kB at 237 kB/s)
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/common-junit3/3.2.5/common-junit3-3.2.5.jar (12 kB at 119 kB/s)
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running com.l0gn3.AppTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.007 s -- in com.l0gn3.AppTest
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] 
[INFO] --- jar:3.4.1:jar (default-jar) @ life-log-man ---
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/shared/file-management/3.1.0/file-management-3.1.0.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/shared/file-management/3.1.0/file-management-3.1.0.jar (36 kB at 308 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/commons-io/commons-io/2.16.1/commons-io-2.16.1.jar
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/maven-archiver/3.6.2/maven-archiver-3.6.2.jar
Downloading from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-interpolation/1.27/plexus-interpolation-1.27.jar
Downloading from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-utils/4.0.1/plexus-utils-4.0.1.jar
Downloading from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-archiver/4.9.2/plexus-archiver-4.9.2.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-archiver/4.9.2/plexus-archiver-4.9.2.jar (225 kB at 1.7 MB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-io/3.4.2/plexus-io-3.4.2.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/maven-archiver/3.6.2/maven-archiver-3.6.2.jar (27 kB at 133 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/commons/commons-compress/1.26.1/commons-compress-1.26.1.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-utils/4.0.1/plexus-utils-4.0.1.jar (193 kB at 953 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/commons/commons-lang3/3.14.0/commons-lang3-3.14.0.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-interpolation/1.27/plexus-interpolation-1.27.jar (86 kB at 423 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/commons-codec/commons-codec/1.16.1/commons-codec-1.16.1.jar
Downloaded from central: https://repo.maven.apache.org/maven2/commons-io/commons-io/2.16.1/commons-io-2.16.1.jar (509 kB at 2.4 MB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/iq80/snappy/snappy/0.4/snappy-0.4.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-io/3.4.2/plexus-io-3.4.2.jar (79 kB at 357 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/tukaani/xz/1.9/xz-1.9.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/tukaani/xz/1.9/xz-1.9.jar (116 kB at 373 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/com/github/luben/zstd-jni/1.5.5-11/zstd-jni-1.5.5-11.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/iq80/snappy/snappy/0.4/snappy-0.4.jar (58 kB at 167 kB/s)
Downloaded from central: https://repo.maven.apache.org/maven2/commons-codec/commons-codec/1.16.1/commons-codec-1.16.1.jar (365 kB at 911 kB/s)
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/commons/commons-lang3/3.14.0/commons-lang3-3.14.0.jar (658 kB at 1.6 MB/s)
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/commons/commons-compress/1.26.1/commons-compress-1.26.1.jar (1.1 MB at 2.2 MB/s)
Downloaded from central: https://repo.maven.apache.org/maven2/com/github/luben/zstd-jni/1.5.5-11/zstd-jni-1.5.5-11.jar (6.8 MB at 8.9 MB/s)
[INFO] Building jar: /Users/aj/Documents/Project-Workspace/L0gN3/3-backend/3.0-devlab/life-log-man/target/life-log-man-1.0-SNAPSHOT.jar
[INFO] 
[INFO] --- install:3.1.2:install (default-install) @ life-log-man ---
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/resolver/maven-resolver-util/1.9.18/maven-resolver-util-1.9.18.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/resolver/maven-resolver-util/1.9.18/maven-resolver-util-1.9.18.jar (196 kB at 1.0 MB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/resolver/maven-resolver-api/1.9.18/maven-resolver-api-1.9.18.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/resolver/maven-resolver-api/1.9.18/maven-resolver-api-1.9.18.jar (157 kB at 1.3 MB/s)
[INFO] Installing /Users/aj/Documents/Project-Workspace/L0gN3/3-backend/3.0-devlab/life-log-man/pom.xml to /Users/aj/.m2/repository/com/l0gn3/life-log-man/1.0-SNAPSHOT/life-log-man-1.0-SNAPSHOT.pom
[INFO] Installing /Users/aj/Documents/Project-Workspace/L0gN3/3-backend/3.0-devlab/life-log-man/target/life-log-man-1.0-SNAPSHOT.jar to /Users/aj/.m2/repository/com/l0gn3/life-log-man/1.0-SNAPSHOT/life-log-man-1.0-SNAPSHOT.jar
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  4.718 s
[INFO] Finished at: 2025-12-02T12:04:16-05:00
[INFO] ------------------------------------------------------------------------

```

# create a basic Spring application
After setting up dependencies, the next step is to create a basic Spring application. 
This involves defining a 1. configuration class, 2. a simple bean, and 3. a main application class. 
Inside the src/main/java/com/example directory, create a class and annotate it with @Configuration. This class defines a bean using the @Bean annotation, which allows Spring to manage and create instances of the bean. 
```java
package com.l0gn3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sun.jvm.hotspot.HelloWorld;

@Configuration
public class AppConfig {
    @Bean   //defines a bean which allows spring to manage bean and create instances of bean.
    public HelloWorld helloWorld() {
        return new HelloWorld();
    }
}

```


Write a separate Java class that represents a Spring bean. This class contains a method that performs basic operations, such as printing a message to the console. 
```java
package com.l0gn3;

/**
 * a separate java class representing the bean.
 * just contains a method that performs basic operations, such as printing a message to the console.
 *
 */
public class HelloWorld {
    public void sayHello() {
        System.out.println("Hello, world!" );
    }
}
```

Develop a main class that initializes the Spring application context, retrieves the bean, and calls its method. Running the program will display Hello World in the console, confirming that the Spring application is functioning correctly.
```java
package com.l0gn3;

/**
 * Main class that initializes Spring application
 * Retrieves bean calls its method that displays output.
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
```

# Run
To compile and run your Spring application, first, use Maven to build the project by running the compile command. Then, execute the main class to start the application. If you are using the command line, run the necessary Maven commands to compile and launch the application.
mvn compile
mvn exec:java -Dexec.mainClass="com.l0gn3.App"
```
aj@AJs-MacBook-Pro life-log-man % mvn compile
[INFO] Scanning for projects...
[INFO] 
[INFO] -----------------------< com.l0gn3:life-log-man >-----------------------
[INFO] Building life-log-man 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- resources:3.3.1:resources (default-resources) @ life-log-man ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /Users/aj/Documents/Project-Workspace/L0gN3/3-backend/3.0-devlab/life-log-man/src/main/resources
[INFO] 
[INFO] --- compiler:3.13.0:compile (default-compile) @ life-log-man ---
[INFO] Nothing to compile - all classes are up to date.
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.157 s
[INFO] Finished at: 2025-12-02T12:40:02-05:00
[INFO] ------------------------------------------------------------------------

....(end)..

aj@AJs-MacBook-Pro life-log-man % mvn exec:java -Dexec.mainClass="com.l0gn3.App"
[INFO] Scanning for projects...
[INFO] 
[INFO] -----------------------< com.l0gn3:life-log-man >-----------------------
[INFO] Building life-log-man 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- exec:3.6.2:java (default-cli) @ life-log-man ---
Hello World!
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.161 s
[INFO] Finished at: 2025-12-02T12:41:13-05:00
[INFO] ------------------------------------------------------------------------
```

Alternatively, if you are using an IDE, right-click Mainapp.java and select Run, or use the shortcut Ctrl + Shift + F10 to execute it. Once the application runs successfully, you should see Hello World printed in the console, confirming that your first Spring application is working correctly. 
 
---

Above has a lot of steps, just use Spring Initialr. it is much easier.


---

# Troubleshooting
*Files and folders disappear from Project view, files are unexpectedly closed in Editor (Mac OS)*
## Symptoms of the problem 
- Files and folders disappear from the Project view
- Files are unexpectedly closed in the Editor window
- All tabs are getting closed when switching to a different app and then returning to IntelliJ IDEA
- Project disappears when the focus is switched outside the IDE
## Cause 
MacOS blocks/restricts access to the project directory when it is stored in one of the following system locations:
Documents
Desktop
Downloads
IDE should notify users when this happens, but it doesn't at the moment. We are working on fixing this in IJPL-2152.
## Solution 1 
Go to Apple menu -> System Settings -> Privacy & Security -> Files and Folders
Grant permission to the IDE to access the abovementioned folders.
## Solution 2 & 3
Go to this link: https://youtrack.jetbrains.com/articles/SUPPORT-A-418/Files-and-folders-disappear-from-Project-view-files-are-unexpectedly-closed-in-Editor-Mac-OS
