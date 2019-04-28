package com.example.viewandgroupview;


import java.util.ArrayList;


public class Movies {
    private String title;
    private int year;
    private String director;
    private String image;
    private String synopsis;

    public Movies(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public String getImage() {
        return image;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public static class Builder {
        Movies movie;

        public Builder() {
            movie = new Movies("");
        }


        public Builder title(String title) {
            movie.title = title;
            return this;
        }

        public Builder year(int year) {
            movie.year = year;
            return this;
        }

        public Builder director(String director) {
            movie.director = director;
            return this;
        }

        public Builder image(String image) {
            movie.image = image;
            return this;
        }

        public Builder synopsis(String synopsis) {
            movie.synopsis = synopsis;
            return this;
        }

        public Movies build() {
            return movie;
        }
    }




    public static Movies[] initMovie() {
        ArrayList<Movies> mymovies = new ArrayList<>();



        mymovies.add(new Movies.Builder()
                .title("Night of the Comet")
                .year(1984)
                .director("")
                .image("http://collider.com/wp-content/uploads/2016/10/night-of-comet.jpg")
                .synopsis("What would kids in the 1980s do if the apocalypse blew through the world without them noticing? Hang out at the mall, but of course. That’s the set-up for this very funny, quite dated horror-comedy, which begins when a quartet of adolescents lock themselves inside a projection booth at the mall’s multiplex. This somehow allows them to live through an extinction level event of some sort, which has also left roaming bands of murderous mutants. Catherine Mary Stewart of the equally inexplicable Weekend at Bernie’s leads the film, but it’s a movie of mood more than substance ultimately. Does the wealth-fueled naiveté of the average white teenager survive in a vacuum? Does it go away when they are being hunted for sustenance? It’s an interesting to watch on these terms and when the zombies show up, director Thom Eberhardt adds menace and a tight feel for suspense to the action sequences. And if we’re being honest, it belongs on this list for its soundtrack alone. The rest of this is just whip cream and cherries. – Chris Cabin")
                .build());

        mymovies.add(new Movies.Builder()
                .title("Dead Snow")
                .year(2009)
                .director("Tommy Wirkola")
                .image("http://collider.com/wp-content/uploads/2016/07/dead-snow.jpg")
                .synopsis("With so many zombie movies over the years, eventually you’re going to run out of ways to freshen up the sub-genre. Enter Wirkola’s decidedly skewed take on zombies in this horror-comedy with plenty of guts. Sure, zombies are great movie monsters, but if you have Nazi zombies, well you’ve just doubled-down on the level of villainy (and pun-worthiness) in your picture! \\nThis splatter-fest puts a Nordic spin on the traditional zombie by adding in elements of the Draugr, an undead creature from Scandinavian folklore that fiercely protects its treasure horde. In the case of Dead Snow, these draugr happen to be former SS soldiers who terrorized a Norwegian town and looted their belongings, only to be done in or chased into the freezing mountains by the villagers themselves. Dead Snow gets originality points for this, for sure. It’s also a very funny, gory, and satisfyingly violent movie with elements of Evil Dead and “teen sex/slasher” flicks scattered throughout. And if you like it, there’s more where that came from in the sequel, Dead Snow: Red vs Dead. – Dave Trumbore")
                .build());

        mymovies.add(new Movies.Builder()
                .title("Cemetery Man")
                .year(2004)
                .director("Michele Soavi")
                .image("http://cdn.collider.com/wp-content/uploads/2017/10/cemetary-man.jpg")
                .synopsis("Directed by Dario Argento protegeMichele Soavi, Cemetery Man (or Dellamorte Dellamore) is a weird, wild head trip of a movie that treats the living dead as more of a nuisance than a deadly threat. Based on the comic series Dylan Dog, Cemetery Man stars Everett as Francesco Dellamorte, a misanthropic gravedigger who prefers the company of the dead to the living. And why wouldn’t he? The living are assholes and they keep spreading rumors he’s impotent. There’s just one catch — the dead won’t stay burried in his graveyard. When he meets a stunning widow (Falchi) at her husband’s funeral, Dellamorte falls head over heels, courts her in the morbid halls of his ossuary, and before you know it, they’re stripped naked and steaming it up on top of her dead husband’s grave. That’s just the start of things getting weird. \\nDellamorte descends into madness, and the further he falls the more Cemetery Man threatens to go off the rails, leaving logic behind in favor of a slipstream psychosis. The result is a bit of a mess without a plot to speak of, but a gloriously weird mess it is. Saturated with philosophy and offbeat humor, Cemetary Man is all about sex and death, friendship and deception; a surrealist, satirical and stylish trip to the brink loaded with splendid visuals and a knockout performance from Everett that takes him from a strapping hero to spitting psychopath. — Haleigh Foutch")
                .build());

        mymovies.add(new Movies.Builder()
                .title("28 Weeks Later")
                .year(1984)
                .director("")
                .image("http://collider.com/wp-content/uploads/2016/10/night-of-comet.jpg")
                .synopsis("")
                .build());

        mymovies.add(new Movies.Builder()
                .title("Night of the Comet")
                .year(2007)
                .director("Juan Carlos Fresnadillo")
                .image("http://collider.com/wp-content/uploads/2015/08/28-weeks-later.jpg")
                .synopsis("28 Weeks Later is one of those rare sequels that does the original proud, especially when the original is a film as acclaimed and influential as 28 Days Later. Director Juan Carlos Fresnadillo made his English-language directorial debut on the sequel, stepping in for Danny Boyle, and pulled off a fantastic trick in honoring the “franchise style” Boyle established in the original — the quick edits and snarling infected — while evolving it and adding his own visual flourish to the mix. \\n 28 Days Later subverted the conventions of the zombie genre in such clever, convincing ways, it became the modern day zombie template that countless films tried to mimic. 28 Weeks Later was smart enough not to follow the blueprint and flipped the script, depicting the British government’s attempt to rebuild society in the aftermath of the rage virus and the subsequent outbreak that brings it all crashing down. Through the contained military facility we get to witness a small-scale version of the viral apocalypse that we missed in the first film and the desperate, hopeless attempts to stop it. That makes 28 Weeks Later is a bit more of a conventional zombie film, depicting the downfall of society and the breakdown of boundaries in times terror, but it’s a very good conventional zombie movie. Fresnadillo hits all the right notes, lacing the broad arc with intimate family drama and depending on his superb cast to sell every moment of heartbreak amidst the bloodshed. — Haleigh Foutch")
                .build());

        mymovies.add(new Movies.Builder()
                .title("Night of the Creeps")
                .year(1986)
                .director("Fred Dekker")
                .image("http://cdn.collider.com/wp-content/uploads/2017/10/night-of-the-creeps.jpg")
                .synopsis("The delightfully delirious directorial debut from Monster Squad helmer Fred Dekker, Night of the Creeps is a loving tribute to the zombie genre that’s as packed to the brim with self-reference as it is with cheeky, cheesy fun. The film follows two college boys trying to land a spot in a fraternity in the name of scoring chicks. To earn their initiation, the boys have to sneak into the college medical center, where they discover the long-frozen corpse of a 1950s coed with alien slugs coursing through his brain. Hijinks follow, the body thaws, and space parasites are unleashed on campus, transforming their hosts into mindless zombies. \\nA blunt-force display of Dekker’s sensibilities, Night of the Creeps is an exuberant blend of zombie genre trappings and the sci-fi B-movies of yore; like Mars Attacks by way of Night of the Living Dead. Dekker lines his film with loving references to the genre, most obviously with his characters, who he names after the horror greats: Romero, Raimi, Carpenter, Cronenberg, Cameron, Landis, and Hooper. Night of the Creeps feels like Dekker took all his favorite movies and stirred them together in a silly, slimy stew. It can be clunky and goofy, but Night of the Creeps wears its idol worship like a badge of honor and Dekker’s creative flourish is a firewall that keeps his homage from becoming derivative. — Haleigh Foutch")
                .build());

        mymovies.add(new Movies.Builder()
                .title("ParaNorman")
                .year(2012)
                .director("Chris Butler, Sam Fell")
                .image("http://collider.com/wp-content/uploads/paranorman-movie-image.jpg")
                .synopsis("Rarely do zombies get the animated treatment (rarer still, stop-motion animation), and even if they do, they’re traditionally made the villains. LAIKA is anything but traditional, which makes their films so endearing, unique, and memorable. ParaNorman, one of the stop-motion studio’s handful of original films, manages to not only (re)animate some truly gruesome and decaying corpses, but to give them a voice and agency within the story. Most live-action movies can’t even achieve that much. \\nBut what truly makes ParaNorman a great zombie tale is that the zombies themselves are more than just part of the spooky story (along with witches, ghosts, and dark magic), they’re a similar stand-in for societal problems first addressed by Romero’s original undead flick. Without giving away too many spoilers, the zombies themselves are reanimated townsfolk from colonial times who have realized the error of their ways but are prevented from setting things right thanks to a witch’s curse. Because they can’t communicate, they’re set upon by an angry mob. While you’d expect that turn of events in a traditional monster movie, the twist in ParaNorman is what lends some substance to its overall message. As a bonus, it’s a zombie movie you can watch with the kids! – Dave Trumbore")
                .build());

        mymovies.add(new Movies.Builder()
                .title("Zombieland")
                .year(2009)
                .director("Ruben Fleischer")
                .image("http://collider.com/wp-content/uploads/Zombieland-movie-image-Woody-Harrelson-Jesse-Eisenberg-1.jpg")
                .synopsis("One of the greatest enjoyments of horror cinema in the last few decades has been watching filmmakers who grew up knowing the rules of the genre find new and exciting ways to subvert them. Shaun of the Dead is the gold star of self-referential cinematic love letters, but Ruben Fleischer’s Zombieland is a rollicking comedy horror in its own right.\\nZombieland arrived in theaters in 2009, towards the end of a new zombie boom, and it’s a film made for audiences who already know the rules and want to have some fun playing the game. The script comes from Deadpool screenwriters Reese and Wernick, and both properties share the duo’s knack for genre deconstruction and razor-sharp, smart-mouthed humor. The ensemble comedic performers has a blast doling out verbal beatdowns in between actually beating down the undead. And let’s be honest — even if Zombieland wasn’t an all-around fun and entertaining action horror, it deserves a spot on the list for giving BIll Murray the most Bill Murray cameo of all time. — Haleigh Foutch")
                .build());

        mymovies.add(new Movies.Builder()
                .title("Planet Terror")
                .year(2007)
                .director("Robert Rodriguez")
                .image("http://collider.com/wp-content/uploads/rose_mcgowan_and_marley_shelton_star_in_robert_rodriquez_s_planet_terror_grindhouse_s.jpg")
                .synopsis("In the tradition of Romero, modern Zombie films have become known as the home of sharp social commentary and forward-thinking humanism. You won’t find any of that in Planet Terror. Initially released as one half of the Robert Rodriguez/Quentin Tarantino double feature Grindhouse, Planet Terror was initially dismissed by critics as the lesser of the two entries, but time has proven it to be a raucous, endlessly rewatchable, and consummately reprobate entry to the zombie genre.Written and directed by Rodriguez (though cast interviews revealed that the directors collaborated freely on both pictures), Planet Terror is cheeky, free-wheeling, and delighted with its own depravity as it employs the shield of grindhouse tropes to hack through horror taboos from child death to testicular violence.\\nBorrowing heavily from the exploitation aesthetic with the kind of budget its forbears could only dream of, the film stars Rose McGowan as Cherry Darling, a brassy go-go dancer who finds herself in the midst of the apocalypse with a rag-tag band of survivors — played by an A+ ensemble of underrated actors who finally get to play the leading roles they’ve always deserved. Flesh-hungry humanoid mutants tear through the Texas countryside, leaving a gooey trail of body parts in their wake. In short order, Cherry winds up with a machine gun for a leg, as you do, and the film boils over into a chaotic free-for-all of bloodshed and grotesqueries. It’s a blast and it triumphs because it leans in so hard. Just look at the “missing reel”  in the second act, which skips everybody’s least favorite part of a zombie movie and jumps right into the climactic third act. And that’s Planet Terror in a nutshell; audacious, goofy and always going right for the guts. — Haleigh Foutch")
                .build());

        mymovies.add(new Movies.Builder()
                .title("Train to Busan")
                .year(2016)
                .director("Sang-ho Yen")
                .image("http://collider.com/wp-content/uploads/2016/12/train-to-busan-movie-image.jpg")
                .synopsis("After the zombie genre got a big boost in the early aughts, the living dead thrived on serialized television but they died off in cinemas for a while. Train to Busan is a proper return to form for the genre, an old-fashioned zombie drama with heart and soul, a simple but clever set-up and some scary af zombies. The film follows a father and his young daughter on a terrifying train ride that sends them speeding through a zombie outbreak in South Korea, trapped inside increasingly infected compartments of the passenger train. Filled with characters you root for —  and some you love to root against — Train to Busan is packed with zombie action that uses the tight quarters to thrilling effect, traveling through the cars of the train with a series of imaginative set-pieces that put the physicality of these contorted, fast-moving zombies to great effect. After watching the living survive among the dead for years on the silver screen, it’s damn well time for someone to give the undead their bite back and Train to Busan is just the ticket. — Haleigh Foutch")
                .build());

        mymovies.add(new Movies.Builder()
                .title("The Beyond")
                .year(1981)
                .director("Lucio Fulci")
                .image("http://cdn.collider.com/wp-content/uploads/2017/10/the-beyond.jpg")
                .synopsis("After making his answer to the Romero school of zombie cinema with Zombi 2, Italian horror maestro Lucio Fulci took the idea of the undead and got weird with it in his unofficial “Gates of Hell” trilogy; City of the Living Dead, The Beyond, and House by the Cemetary. The Beyond has proven the most enduring of the lot, and for good reason, it’s a hypnotic oddity, as unsettling as it is incoherent.\\nIf you walk into The Beyond assuming the plot matters (it really doesn’t), the film follows a young woman (MacColl), who inherits a Louisianna hotel that, bad news, happens to be built on one of the gates to hell. In between the eye-gouging, acid face-melting, and all manner of blood and guts Fulci conjures up for his ghastly visions (The Beyond isn’t quite as gory as Zombi 2, but it’s close)., there’s also a brewing metaphysical dread, a sense of doom that bubbles up to a screaming boil in the film’s final reveal. — Haleigh Foutch")
                .build());

        mymovies.add(new Movies.Builder()
                .title("Day of the Dead")
                .year(1985)
                .director("George Romero")
                .image("http://cdn.collider.com/wp-content/uploads/2017/10/day-of-the-dead.jpg")
                .synopsis("The concluding chapter in Romero’s original “Dead” trilogy, Day of the Dead has never found the frenzied fans of its two predecessors. In fact, it’s often been met with some harsh criticisms, which is unfortunate because it’s a staggering zombie film in its own right. Perhaps its the idea of sentient zombies, a tenet of Romero’s later “Dead” films introduced in Day of the Dead via Bub, the loveable flesh-hungry fiend who begins to show signs of cognizance during military testing. Or maybe it’s the script, which turns up the volume on Romero’s trademark cultural critique until the skewering tips over into preachy territory.\\nBut here’s the thing, while other filmmakers may have been happy to recreate the formula that worked for them in the past, Romero consistently evolved his living dead films, and Day of the Dead was the boldest of them all. Set on a military base, Romero gets downright political, asking hard questions about power and how much any one organization should or can ever have. It’s a pensive film, not quite as primal as Night of the Living Dead and nowhere near as funny as Dawn of the Dead, which makes it a slow watch. But hoo boy, if you came for zombie gore, is the payoff rewarding. Day of the Dead has some of the most stomach-churning, sticky practical effects in the history of horror, practically painting the sterile military base red in the final act.  — Haleigh Foutch")
                .build());



        Movies[] films = new Movies[mymovies.size()];
        films = mymovies.toArray(films);
        return films;
    }

}

