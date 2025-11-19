Prompt: 
Folder and File naming convention best practices for GitHub, 
should I use numbers first then underscore then name for folder? 
For files that are for documentation, frontend react project files, 
backend spring boot project files. And API? 
Can you suggest a Best practices in naming convention?

ChatGPT: 
Here is a clean, modern, industry-ready naming convention guide you can follow for GitHub folders, documentation files, backend Java/Spring Boot code, frontend React code, and API naming.
This is the same style used by big companies (Google, Meta, Stripe, Airbnb, Netflix).

✅ 1. General Folder Naming Conventions (GitHub Repo)
Best Practices

✔ Use lowercase
✔ Use hyphens (-) instead of underscores or spaces
✔ Do NOT prefix with numbers unless ordering matters
✔ Keep names semantic, short, and consistent

❌ Avoid

01_folder_name/

Backend_Project/

My Files/

camelCaseFolder

✅ Do

backend/

frontend/

api-specs/

system-design/

uml-diagrams/

💡 Why hyphens?

Hyphens are most universal — compatible with Linux, URLs, npm, Java packages, and CLI tools.

✅ 2. Documentation File Naming Conventions
Best practices:

✔ Keep filenames lowercase-with-hyphens
✔ Use .md for all documentation
✔ Include a clear topic name

Examples:
README.md
system-design.md
data-modeling.md
architecture-overview.md
api-reference.md
security-guidelines.md
deployment-guide.md
troubleshooting.md
changelog.md

❌ Don’t:
System_Design_v1_FINAL.md
2-SystemDesign.md
API Specs.md

✅ 3. Frontend (React) Naming Conventions
Folders

Use lowercase with hyphens:

src/
  components/
  pages/
  hooks/
  utils/
  assets/
  styles/

React Components

✔ PascalCase for component files and folders

UserCard.jsx
LoginForm.jsx
DashboardPage.jsx


✔ Files inside a component folder:

UserCard/
  index.jsx
  user-card.jsx
  user-card.css

Other files

✔ camelCase for utilities & hooks:

fetchUser.js
useAuth.js
formatDate.js

✅ 4. Backend (Java / Spring Boot)
Java Package Structure

✔ Always use lowercase + dot notation
✔ No underscores, no hyphens

com.l0gn3.lifemanlog
com.l0gn3.stealthagon
com.l0gn3.artelligenie

Folder Structure
src/main/java/com/l0gn3/app/
    controller/
    service/
    repository/
    config/
    model/
src/main/resources/
    application.yml

Class naming

✔ PascalCase

UserController.java
AuthService.java
UserRepository.java
JwtConfig.java
SecurityFilter.java

Method naming

✔ camelCase

getUser()
generateToken()
validateRequest()

✅ 5. API Naming Conventions (REST)
Endpoints

✔ lower-case
✔ hyphens in URL
✔ nouns, not verbs
✔ versioned

Example:
/api/v1/users
/api/v1/users/{id}
/api/v1/auth/login
/api/v1/ai/generate
/api/v1/security/scan

Response fields

✔ snake_case (industry standard for APIs)
OR camelCase (if frontend prefers it)

Pick one and stay consistent.

⭐ Recommended Style for You (Clean & Professional)
For folders:

lowercase-with-hyphens

For JS/React files:

PascalCase for components, camelCase for helpers

For Java files:

PascalCase for classes, camelCase for methods

For APIs:

lowercase-hyphens + versioning: /api/v1/...

For documentation:

lowercase-hyphens.md
