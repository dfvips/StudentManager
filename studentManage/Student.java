/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package studentManage;

import java.io.Serializable;

/**
 *
 * @author remote
 */
public class Student implements Serializable{
    private String id;
    private String name;
    private int score;
    public Student()
    {
        super();
    }
     public Student(String id,String name,int score)
    {
        super();
        this.id=id;
        this.name=name;
        this.score=score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    
}
