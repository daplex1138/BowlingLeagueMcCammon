package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="team")
public class Team {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="teamId")
	private int teamId;
	@Column(name="teamName")
	private String teamName;
	@Column(name="teamType")
	private String teamType;
	@Column(name="preferredNight")
	private String preferredNight;
	
	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Team(String teamName, String teamType, String preferredNight) {
		super();
		this.teamName = teamName;
		this.teamType = teamType;
		this.preferredNight = preferredNight;
	}

	public Team(int teamId, String teamName, String teamType, String preferredNight) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
		this.teamType = teamType;
		this.preferredNight = preferredNight;
	}

	/**
	 * @return the teamId
	 */
	public int getTeamId() {
		return teamId;
	}


	/**
	 * @param teamId the teamId to set
	 */
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}


	/**
	 * @return the teamName
	 */
	public String getTeamName() {
		return teamName;
	}


	/**
	 * @param teamName the teamName to set
	 */
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}


	/**
	 * @return the teamType
	 */
	public String getTeamType() {
		return teamType;
	}


	/**
	 * @param teamType the teamType to set
	 */
	public void setTeamType(String teamType) {
		this.teamType = teamType;
	}


	/**
	 * @return the preferredNight
	 */
	public String getPreferredNight() {
		return preferredNight;
	}


	/**
	 * @param preferredNight the preferredNight to set
	 */
	public void setPreferredNight(String preferredNight) {
		this.preferredNight = preferredNight;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", teamName=" + teamName + ", teamType=" + teamType + ", preferredNight="
				+ preferredNight + "]";
	}
	
	
}
