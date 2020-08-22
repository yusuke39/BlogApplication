import { shallowMount } from '@vue/test-utils'
import MyComponent from '../src/views/hello.vue'

// コンポーネントをマウントします。
const wrapper = shallowMount(MyComponent)

// テストランナーや検証には、どのようなライブラリを用いても構いませんが
// ここでは Jest を用いたテスト記述を行っています。
describe('MyComponent', () => {
  // コンポーネントの options を直接検証します。
  it('has a created hook', () => {
    expect(typeof MyComponent.created).toBe('function')
  })

  // コンポーネントの options 内にある関数を実行し、
  // 結果を検証します。
  it('sets the correct default data', () => {
    expect(typeof MyComponent.data).toBe('function')
    const defaultData = MyComponent.data()
    expect(defaultData.message).toBe('hello!')
  })

  // コンポーネントインスタンスをマウントして検証します。
  it('correctly sets the message when created', () => {
    expect(wrapper.vm.$data.message).toBe('bye!')
  })

  it('renders the correct message', () => {
    expect(wrapper.text()).toBe('bye!')
  })
})