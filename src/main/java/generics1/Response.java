package generics1;

public class Response<T> extends BaseResponse {
    private static final long serialVersionUID = -7497345490046935161L;

    private T data;

    private String code;

    public Response() {
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data, String code) {
        this.data = data;
        this.code = code;
    }
}
