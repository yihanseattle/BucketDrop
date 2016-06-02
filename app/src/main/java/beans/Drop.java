package beans;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by HanYi on 6/2/16.
 */
public class Drop extends RealmObject {

    private String what;
    @PrimaryKey
    private long added;
    private long when;
    private boolean isCompleted;

    public Drop() {
    }

    public Drop(String what, long added, long when, boolean isCompleted) {
        this.added = added;
        this.isCompleted = isCompleted;
        this.what = what;
        this.when = when;
    }

    public long getAdded() {
        return added;
    }

    public void setAdded(long added) {
        this.added = added;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }

    public long getWhen() {
        return when;
    }

    public void setWhen(long when) {
        this.when = when;
    }
}
