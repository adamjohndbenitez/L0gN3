Introduction to Outlier - Onboarding - Outlier Task Types: Rubrics - Rubrics Quick Intro 


(In the video translation) At Outlier, we feed AI an array of challenges to make it sharper and curious. A panel to the left called RLHF. and two panels, the top called GTFA and the bottom called Rubrics.
(attached screenshot in ChatGPT)


[The Rubrics Task - creating an effective rubric is like writing a great recipe, after you already tasted the meal, imagine a scenario where you ask your friends to all make the same meal. Prompt: Make a delicious noodle dish. They all mostly come up with pretty different taste on the meal with varying levels of tastiness]

Rubrics-Cooking
User
Make a delicious noodle dish
Write criteria that encompass all requirements needed to fulfill this prompt.
1. Contains a clear pasta component (any noodle type) that is fully cooked, not raw or undercooked. Instruction following. 5 points. Objective. Explicit.
2. Thoughtfufl inclusion of proteins or vegetables that complement the dish. Completeness. 3 points. Objective. Implicit
3. (Input Field/Text Box) Describe a distinct, objective reuirement for the resonse. Remember to be atomic, mutually exclusive, and collectively exhaustive.
    - Category: if unsure, reference the category definitions (Dropdown options eg. Completeness)
    - Weight: Relative significance to the overall rubric (Number Input eg. 1) points(s)
    - Objective or subjective?: Evaluation is directly linked to instructions or measurable conditions. (Dropdown options eg. Subjective)
    - Explicitly stated in prompt?: Rubric is explicitly stated within the prompt or instructions. (Dropdown options eg. Implicit)


Model
Rate each response based on the criteria established.
Response A: Frozen cheese ravioli served a bit over reheated, topped with grilled chicken and homemade marinara sauce.
Response B: Perfectly cooked, homemade spaghetti with a hearty tomato basil suace, topped with meatballs and parmesean cheese.
Response C: Packaged cup noodles, reheated and served with broth.

[This variations highlight the diverse approaches the creativity involved, much like how model generate varied responses. Your job is to evaluate each dish, while assuring what they made is fundamentally what you asked for which involves assessing flavor presentation and creativity, much like judging a model response]

PastaMeatballs
Ravioli
CupNoodles

Then you'll write the recipe to make the best version of the meal (Rubric Criteria) Hence for a perfect dish

User
Make a delicious noodle dish.
- Write criteria 3 critera written

Model
3 responses rated 3 criterion per response

