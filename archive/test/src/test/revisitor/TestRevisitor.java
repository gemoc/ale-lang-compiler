package test.revisitor;

public interface TestRevisitor<Test__YoloT> {
	Test__YoloT test__Yolo(final test.Yolo it);

	default Test__YoloT $(final test.Yolo it) {
		return test__Yolo(it);
	}
}
