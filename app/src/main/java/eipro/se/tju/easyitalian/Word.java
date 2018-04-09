package eipro.se.tju.easyitalian;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Word {
    @Id
    private Long id;

    @Property(nameInDb = "word")
    private String word;

    @Property(nameInDb = "transform")
    private String transform;

    @Property(nameInDb = "translation")
    private String translation;

    @Property(nameInDb = "example")
    private String example;

    @Property(nameInDb = "appearTime")
    private Integer appearTime;

    @Property(nameInDb = "correctTime")
    private Integer correctTime;

    @Property(nameInDb = "incorrectTime")
    private Integer incorrectTime;

    @Generated(hash = 236107239)
    public Word(Long id, String word, String transform, String translation,
            String example, Integer appearTime, Integer correctTime,
            Integer incorrectTime) {
        this.id = id;
        this.word = word;
        this.transform = transform;
        this.translation = translation;
        this.example = example;
        this.appearTime = appearTime;
        this.correctTime = correctTime;
        this.incorrectTime = incorrectTime;
    }

    @Generated(hash = 3342184)
    public Word() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWord() {
        return this.word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTransform() {
        return this.transform;
    }

    public void setTransform(String transform) {
        this.transform = transform;
    }

    public String getTranslation() {
        return this.translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getExample() {
        return this.example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public Integer getAppearTime() {
        return this.appearTime;
    }

    public void setAppearTime(Integer appearTime) {
        this.appearTime = appearTime;
    }

    public Integer getCorrectTime() {
        return this.correctTime;
    }

    public void setCorrectTime(Integer correctTime) {
        this.correctTime = correctTime;
    }

    public Integer getIncorrectTime() {
        return this.incorrectTime;
    }

    public void setIncorrectTime(Integer incorrectTime) {
        this.incorrectTime = incorrectTime;
    }
    
}
