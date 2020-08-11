<script>
import { Line } from 'vue-chartjs'

export default {
  extends: Line,
  name: 'lineGraph',
  data () {
    return {
      data: {
        labels: ['1月', '２月', '３月', '4月', '５月', '6月', '7月', '8月', '9月', '10月', '11月', '12月'],
        datasets: [
          {
            label: '今年の投稿数',
            data: [10, 50, 20, 30, 30, 40],
            borderColor: '#55C500',
            fill: false,
            type: 'line',
            lineTension: 0.3
          }
        ]
      },
      options: {
        scales: {
          xAxes: [{
            scaleLabel: {
              display: true,
              labelString: '月'
            }
          }],
          yAxes: [{
            ticks: {
              beginAtZero: true,
              stepSize: 10
            }
          }]
        }
      }
    }
  },
  mounted () {
    this.renderChart(this.data, this.options)
  }
}
</script>
