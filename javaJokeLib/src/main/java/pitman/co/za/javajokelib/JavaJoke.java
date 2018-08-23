package pitman.co.za.javajokelib;

import java.util.ArrayList;
import java.util.Random;

/*
* Java library of 10 lame one-liners
* */
public class JavaJoke {

    private ArrayList<String> lameOneLiners;

    public JavaJoke() {
        // https://forums.macrumors.com/threads/corny-jokes-and-one-liners.1188014/
        lameOneLiners = new ArrayList<>();
        lameOneLiners.add("If you want to catch a squirrel just climb a tree and act like a nut.");
        lameOneLiners.add("What kind of shoes are made from bananas skins? Slippers.");
        lameOneLiners.add("What kind of rooms have no walls? Mushrooms.");
        lameOneLiners.add("Why do golfers wear two pairs of pants? In case they get a hole in one.");
        lameOneLiners.add("Have you heard of the new restaurant on the moon? The food is amazing, but I've heard its got no atmosphere...");
        lameOneLiners.add("I wondered why the frisbee was getting bigger, and then it hit me.");
        lameOneLiners.add("Dave drowned. So at the funeral we got him a wreath in the shape of a lifebelt. Well, it's what he would have wanted.");
        lameOneLiners.add("My friend has a world record for concussions, he lives very close. In fact, just a stones throw away.");
        lameOneLiners.add("Teach a child to be polite and courteous, and when he grows up, he'll never be able to edge his car onto a freeway.");
        lameOneLiners.add("Two fish were in a tank. One said 'You man the guns, I'll drive!'");
    }

    public String getJoke() {
        return lameOneLiners.get(getRandomJokeIndex());
    }

    private static int getRandomJokeIndex() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
