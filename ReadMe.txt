1. API to create space called “stc-assessments”, and assign a permission group like admin
group, containing a user with VIEW access and another one with EDIT access.
2. API to create folder under “stc-assessments” space, called “backend”, making sure that
the user has EDIT access on this space, blocking user that has VIEW access.
3. API to create file under “backend” folder, called “assessment.pdf”, making sure that the
user has EDIT access on this folder, blocking user that has VIEW access.
