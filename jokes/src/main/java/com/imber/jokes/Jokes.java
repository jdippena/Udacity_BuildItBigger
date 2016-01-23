package com.imber.jokes;

import java.util.Random;

public class Jokes {
    Random mRandom;
    // shamelessly taken from www.laughfactory.com
    private String[] mJokes = {
            "Helium walks into a bar and asks for a drink. The bartender says, \"Sorry, we don't serve noble gases here.\" Helium doesn't react.",
            "Q: Why can't you trust an atom? \n" +
                    "A: Because they make up everything.",
            "A teacher asked her students to use the word \"beans\" in a sentence. \"My father grows beans,\" said one girl. \"My mother cooks beans,\" said a boy. A third student spoke up, \"We are all human beans.\"",
            "Q: Can a kangaroo jump higher than the Empire State Building? \n" +
                    "A: Of course. The Empire State Building can't jump.",
            "Q: Why does Humpty Dumpty love autumn? \n" +
                    "A: Because Humpty Dumpty had a great fall.",
            "Q: Did you hear about the kidnapping at school? \n" +
                    "A: It's okay. He woke up.",
            "Teacher: \"Which book has helped you the most in your life?\" \n" +
                    "Student: \"My parent's check book!\"",
            "Q: What do you call a pig that does karate? \n" +
                    "A: A pork chop.",
            "I was wondering why the ball kept getting bigger and bigger, and then it hit me.",
            "If you ever get cold, just stand in the corner of a room for a while. They're normally around 90 degrees.",
            "Teacher: \"What is the chemical formula for water?\" \n" +
                    "Student: \"HIJKLMNO.\" \n" +
                    "Teacher: \"What are you talking about?\" \n" +
                    "Student: \"Yesterday you said it's H to O!\""
    };

    public Jokes() {
        mRandom = new Random();
    }

    /**
     * @return A joke that everyone loves
     */
    public String getJoke() {
        int idx = mRandom.nextInt(mJokes.length);
        return mJokes[idx];
    }
}
