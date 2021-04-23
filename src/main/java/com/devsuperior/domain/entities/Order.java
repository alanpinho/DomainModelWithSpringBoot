package com.devsuperior.domain.entities;

import java.time.Instant;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_order")
public class Order {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		private Instant moment;
		private OrderStatus status;
		
		@ManyToOne
		@JoinColumn(name="client_id") //coluna da chave estrangeira
		private Client client;
		
		
		@OneToMany(mappedBy = "order")	
		private List<OrderItem> items;
		
		public double getTotal() {
			double sum = 0.0;
			for (OrderItem item : items) {
				sum += item.getSubTotal();
			}
			return sum;
		}
		
		@ManyToOne
		@NotNull
		private TestingObjectThisCanBeDeleted test;
}
