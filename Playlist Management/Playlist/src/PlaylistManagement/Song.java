package PlaylistManagement;

public class Song {
	String taskname;
	double duration;
	String category;
	
	public Song(String name, double duration, String category) {
		
		this.taskname = name;
		this.duration = duration;
		this.category = category;
	}
	
	public double getDuration() {
		return this.duration;
	}
	
	public String getCategory() {
		return this.category;
	}
	
	public String toString() {
		return this.taskname+ " | " + String.valueOf(this.duration) + " | " + this.category;
	}
}
