package guestbook.model;

import java.util.List;

public class MessageListView {
	
	private int messageCountPerPage;
	private int messageTotalCount;

	private int pageTotalCount;
	private int curruntPageNumber;

	private List<Message> messageList;
	private int firstRow;
	private int endRow;
	
	
	public MessageListView(int messageCountPerPage, int messageTotalCount, int curruntPageNumber,
			List<Message> messageList, int firstRow) {
		super();
		this.messageCountPerPage = messageCountPerPage;
		this.messageTotalCount = messageTotalCount;
		this.curruntPageNumber = curruntPageNumber;
		this.messageList = messageList;
		this.firstRow = firstRow;
		calculatePageTotalCount();
	}//constructor
	
	
	private void calculatePageTotalCount() {
		if(messageTotalCount == 0) {
			pageTotalCount = 0;
			
		} else {
			pageTotalCount = messageTotalCount / messageCountPerPage;
			if(messageTotalCount % messageCountPerPage >0 ) {
				pageTotalCount++;
			}
		}
	}//calculatePageTotalCount


	public int getMessageCountPerPage() {
		return messageCountPerPage;
	}


	public int getMessageTotalCount() {
		return messageTotalCount;
	}


	public int getPageTotalCount() {
		return pageTotalCount;
	}


	public int getCurruntPageNumber() {
		return curruntPageNumber;
	}


	public List<Message> getMessageList() {
		return messageList;
	}


	public int getFirstRow() {
		return firstRow;
	}


	public boolean isEmpty() {
		return messageTotalCount == 0 ;
	}
	
	
}
