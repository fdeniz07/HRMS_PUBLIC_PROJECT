package test.hrms2.core.results;

public class DataResult<T> extends Result {

	private T data;

	public DataResult(T data, boolean success, String message) {
		super(success, message); // super : Base sinifin metotlarini calistirir
		this.data = data;
	}

	public DataResult(T data, boolean success) {
		super(success);
		this.data = data;
	}

	public T getData() {
		return this.data;
	}
}
