
public enum Channel {
	ABC(10), NATGEO(11), DISNEYJR(12), FREEFORM(13), ESPN(14);
	
	private int channelNum;

	private Channel(int channelNum)
	{
		this.channelNum = channelNum;
	}
	
	public int getChannelNum()
	{
		return channelNum;
	}

}
