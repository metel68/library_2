import React, {Component} from 'react';
import API from "../api/Api";
import styled from "styled-components";

export default class CategoryRow extends Component {
  deleteCategory = async () => {
    const { category } = this.props;
    const response = await API.deleteCategory(category.value);
    document.location.reload();
  };

  render() {
    const { category } = this.props;
    console.log(category);

    return (
      <tr className="user-row">
        <Cell>{category.text}</Cell>
        <Cell>
          <a className="category-remove" href="#" onClick={this.deleteCategory}>Удалить</a>
        </Cell>
      </tr>
    );
  }
}

const Cell = styled.td`
  padding: 0 0 10px 30px;
`;
