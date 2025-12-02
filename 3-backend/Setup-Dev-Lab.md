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
    

Once the project structure is understood, the next step is to add the required dependencies. Open the pom.xml file and include the necessary Spring libraries. These dependencies provide essential features for building a Spring application.   
Then, run mvn clean install in your terminal to download the dependencies. 


# create a basic Spring application
After setting up dependencies, the next step is to create a basic Spring application. 
This involves defining a 1. configuration class, 2. a simple bean, and 3. a main application class. 
Inside the src/main/java/com/example directory, create a class and annotate it with @Configuration. This class defines a bean using the @Bean annotation, which allows Spring to manage and create instances of the bean. 
      


Write a separate Java class that represents a Spring bean. This class contains a method that performs basic operations, such as printing a message to the console. 
