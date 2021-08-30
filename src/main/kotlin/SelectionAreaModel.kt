class SelectionAreaModel (val onChange: () -> Any) {
    var xStart : Int = 0
    var yStart : Int = 0
    var xEnd : Int   = 0
    var yEnd : Int   = 0

    fun setAreaPositions (xStart : Int = this.xStart,
                          yStart : Int = this.yStart,
                          xEnd : Int = this.xEnd,
                          yEnd : Int = this.yEnd) {
        this . xStart = xStart
        this . yStart = yStart
        this . xEnd = xEnd
        this . yEnd = yEnd

        onChange ()
    }
}