module.exports = {
  presets: [
      [
          '@babel/preset-env',
          {
              'useBuiltIns': 'usage',
              'targets': '> 0.25%, not dead'
          }
      ]
  ],
  env: {
      test: {
          presets: [['@babel/preset-env', {targets: {node: 'current'}}]]
      }
  }
}