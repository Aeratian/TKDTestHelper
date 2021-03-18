public class Question
{
    private String question;
    private String belt;
    private String answer;
    public Question (String b, String q, String a) {
        question = q;
        belt = b;
        answer = a;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getBelt() {
        return belt;
    }

    public void setBelt(String belt) {
        this.belt = belt;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}