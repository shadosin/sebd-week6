package com.kenzie.supportingmaterials;

import java.util.ArrayList;
import java.util.Random;

public class FortuneTeller {
    public int state; // 0 for unlucky, 1 for lucky
    
    private final ArrayList<String> fortunes = new ArrayList<>() {{
     add("If you had one shot, or one opportunity");
     add("To seize everything you ever wanted");
     add("Would you capture it or just let it slip?");
     add("His palms are sweaty, knees weak, arms are heavy");
     add("He opens his mouth, but the words won't come out");
     add("He's choking how, everybody's joking now");
     add("The clock's run out, time's up, over, blaow!");
     add("Snap back to reality");
     add("He's so mad, but he won't give up that easy, no");
     add("He won't have it, he knows his whole back's to these ropes");
     add("He better go capture this moment and hope it don't pass him");
     add("You better lose yourself in the music, the moment");
     add("You own it, you better never let it go");
     add("You only get one shot, do not miss your chance to blow");
     add("This opportunity comes once in a lifetime");
     add("You better");
     add("The soul's escaping, through this hole that is gaping");
     add("This world is mine for the taking");
     add("Make me king, as we move toward a new world order");
     add("A normal life is boring, but superstardom's close to post mortem");
     add("It only grows harder, homie grows hotter");
     add("These hoes is all on him");
     add("Coast to coast shows, he's known as the globetrotter");
     add("Lonely roads, God only knows");
     add("He's knows is grown farther from home, he's no father");
     add("He goes home and barely knows his own daughter");
     add("But hold your nose 'cause here goes the cold water");
     add("They moved on to the next schmoe who flows");
     add("He nose dove and sold nada");
     add("So the soap opera is told and unfolds");
     add("I suppose it's old partner but the beat goes on");
     add("Da da dum, da dum da da");
     add("You own it, you better never let it go");
     add("You only get one shot, do not miss your chance to blow");
     add("This opportunity comes once in a lifetime");
     add("You better lose yourself in the music, the moment");
     add("You own it, you better never let it go");
     add("You only get one shot, do not miss your chance to blow");
     add("This opportunity comes once in a lifetime");
    }};


    public String guess() {
        Random flipper = new Random();
        int randomInt = flipper.nextInt(fortunes.size() - 1);
        this.state = randomInt;
        return this.fortunes.get(randomInt);
    }


}
